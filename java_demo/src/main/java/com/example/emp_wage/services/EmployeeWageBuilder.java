package com.example.emp_wage.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.example.emp_wage.interfaces.EmployeeWageInterface1;
import com.example.emp_wage.models.Company;
import com.example.emp_wage.models.Employee1;
import com.example.emp_wage.models.Employee2;

public class EmployeeWageBuilder implements EmployeeWageInterface1 {

	// Declare static content
	static final int FULL_TIME = 1;
	static final int PART_TIME = 2;

	@Override
	public void initialize(Employee1 employee, Company[] companyList) {
		employee.setCompanyList(companyList);
	}

	@Override
	public void initialize(Employee2 employee, List<Company> companyList) {
		employee.setCompanyList(companyList);
	}

	public Company getDetails(int wagePerHour, int workingDaysInMonth, int totalWorkingHours, int fullDayShiftHrs,
			int halfDayShiftHrs) {
		Company company = new Company();
		company.setTotalWorkingHours(totalWorkingHours);
		company.setWagePerHour(wagePerHour);
		company.setWorkingDaysInMonth(workingDaysInMonth);
		company.setFullDayShiftHrs(fullDayShiftHrs);
		company.setHalfDayShiftHrs(halfDayShiftHrs);

		return company;
	}

	public int calculate(List<Company> companyList) {

		Random random = new Random();

		int empDailyWage = 0;
		int empWorkHrs;
		int workDayCount;

		for (Company c : companyList) {

			// Initialize the local variables
			empWorkHrs = 0;
			workDayCount = 0;
			// Iterate till the working-month is over or the employee-monthly working hours
			// are fulfilled
			while (workDayCount < c.getWorkingDaysInMonth() && empWorkHrs < c.getTotalWorkingHours()) {
				// Generate a random number for employee shift type for each day
				int empStatus = random.nextInt(3);
				// increment the working-day count
				++workDayCount;
				// Check for the employee shift type on the day and calculate the daily wage and
				// add it to the monthly wage amount
				switch (empStatus) {
				case FULL_TIME:
					empWorkHrs += c.getFullDayShiftHrs();
					empDailyWage += c.getWagePerHour() * c.getFullDayShiftHrs();
					System.out.println("Day " + workDayCount + ": The Employee is a FULL-TIME shift");
					break;
				case PART_TIME:
					empWorkHrs += c.getHalfDayShiftHrs();
					empDailyWage += c.getWagePerHour() * c.getHalfDayShiftHrs();
					System.out.println("Day " + workDayCount + ": The Employee is a PART-TIME shift");
					break;
				default:
					System.out.println("Day " + workDayCount + ": The Employee is absent");
				}
			}
		}
		return empDailyWage;
	}

	public List<Integer> getDailyWageList(List<Company> companyList) {

		Random random = new Random();

		List<Integer> dailyWageList = new ArrayList<>();
		int empWorkHrs;
		int workDayCount;

		for (Company c : companyList) {

			// Initialize the local variables
			empWorkHrs = 0;
			workDayCount = 0;
			// Iterate till the working-month is over or the employee-monthly working hours
			// are fulfilled
			while (workDayCount < c.getWorkingDaysInMonth() && empWorkHrs < c.getTotalWorkingHours()) {
				// Generate a random number for employee shift type for each day
				int empStatus = random.nextInt(3);
				// increment the working-day count
				++workDayCount;
				// Check for the employee shift type on the day and calculate the daily wage and
				// add it to the monthly wage amount
				switch (empStatus) {
				case FULL_TIME:
					empWorkHrs += c.getFullDayShiftHrs();
					dailyWageList.add(c.getWagePerHour() * c.getFullDayShiftHrs());
					System.out.println("Day " + workDayCount + ": The Employee is a FULL-TIME shift");
					break;
				case PART_TIME:
					empWorkHrs += c.getHalfDayShiftHrs();
					dailyWageList.add(c.getWagePerHour() * c.getHalfDayShiftHrs());
					System.out.println("Day " + workDayCount + ": The Employee is a PART-TIME shift");
					break;
				default:
					dailyWageList.add(0);
					System.out.println("Day " + workDayCount + ": The Employee is absent");
				}
			}
		}
		return dailyWageList;
	}

	public int getTotalWage(List<Integer> dailyWageList) {
		int totalWage = 0;
		for (int dailyWage : dailyWageList)
			totalWage += dailyWage;
		return totalWage;
	}

	public void EmployeeWageCalculator(Employee1 emp) {
		emp.setMonthlyWageAmt(calculate(Arrays.asList(emp.getCompanyList())));
		System.out.println("The person's monthly wage is " + emp.getMonthlyWageAmt());
	}

	public void EmployeeWageCalculator(Employee2 emp, boolean isDailyWageRequired) {

		if (isDailyWageRequired) {
			List<Integer> dailyWageList = getDailyWageList(emp.getCompanyList());
			emp.setMonthlyWageAmt(getTotalWage(dailyWageList));
		} else {
			emp.setMonthlyWageAmt(calculate(emp.getCompanyList()));
		}
		System.out.println("The person's monthly wage is " + emp.getMonthlyWageAmt());
	}

}
