package com.example.emp_wage;

import java.util.Random;

//EmployeeWage class
public class EmployeeWageUC10 {
	// Declare static content
	static final int FULL_TIME = 1;
	static final int PART_TIME = 2;

	// Create a company class with the instance variables
	public class Company {
		private int wagePerHour;
		private int workingDaysInMonth;
		private int totalWorkingHours;
		private int fullDayShiftHrs;
		private int halfDayShiftHrs;

		public int getWagePerHour() {
			return wagePerHour;
		}

		public void setWagePerHour(int wagePerHour) {
			this.wagePerHour = wagePerHour;
		}

		public int getWorkingDaysInMonth() {
			return workingDaysInMonth;
		}

		public void setWorkingDaysInMonth(int workingDaysInMonth) {
			this.workingDaysInMonth = workingDaysInMonth;
		}

		public int getTotalWorkingHours() {
			return totalWorkingHours;
		}

		public void setTotalWorkingHours(int totalWorkingHours) {
			this.totalWorkingHours = totalWorkingHours;
		}

		public int getFullDayShiftHrs() {
			return fullDayShiftHrs;
		}

		public void setFullDayShiftHrs(int fullDayShiftHrs) {
			this.fullDayShiftHrs = fullDayShiftHrs;
		}

		public int getHalfDayShiftHrs() {
			return halfDayShiftHrs;
		}

		public void setHalfDayShiftHrs(int halfDayShiftHrs) {
			this.halfDayShiftHrs = halfDayShiftHrs;
		}
	}

	public class EmployeeWageBuilder {
		private int monthlyWageAmt;
		private Company[] companyList;

		public int getMonthlyWageAmt() {
			return monthlyWageAmt;
		}

		public void setMonthlyWageAmt(int monthlyWageAmt) {
			this.monthlyWageAmt = monthlyWageAmt;
		}

		public Company[] getCompanyList() {
			return companyList;
		}

		public void setCompanyList(Company[] companyList) {
			this.companyList = companyList;
		}
	}

	public static void main(String[] args) {
		EmployeeWageUC10 employeeWage = new EmployeeWageUC10();
		// Initialize the company object with the parameters;
		Company company1 = employeeWage.new Company();
		company1.setTotalWorkingHours(100);
		company1.setWagePerHour(20);
		company1.setWorkingDaysInMonth(20);
		company1.setFullDayShiftHrs(8);
		company1.setHalfDayShiftHrs(4);

		Company company2 = employeeWage.new Company();
		company2.setTotalWorkingHours(120);
		company2.setWagePerHour(30);
		company2.setWorkingDaysInMonth(25);
		company2.setFullDayShiftHrs(10);
		company2.setHalfDayShiftHrs(5);

		Company[] companyList = { company1, company2 };

		// Initialize the employee object with the parameters
		EmployeeWageBuilder employee = employeeWage.new EmployeeWageBuilder();
		employee.setCompanyList(companyList);

		// Pass the company object as argument to the class method
		EmployeeWageCalculator(employee);
	}

	// Class-method
	public static void EmployeeWageCalculator(EmployeeWageBuilder emp) {

		Random random = new Random();

		int empDailyWage = 0;
		int empWorkHrs;
		int workDayCount;

		for (Company c : emp.getCompanyList()) {

			// Initialize the local variables
			empWorkHrs = 0;
			workDayCount = 0;
			// Iterate till the working-month is over or the employee-monthly working hours
			// are fulfilled
			while (workDayCount < c.workingDaysInMonth && empWorkHrs < c.totalWorkingHours) {
				// Generate a random number for employee shift type for each day
				int empStatus = random.nextInt(3);
				// increment the working-day count
				++workDayCount;
				// Check for the employee shift type on the day and calculate the daily wage and
				// add it to the monthly wage amount
				switch (empStatus) {
				case FULL_TIME:
					empWorkHrs += c.getFullDayShiftHrs();
					empDailyWage += c.wagePerHour * c.getFullDayShiftHrs();
					System.out.println("Day " + workDayCount + ": The Employee is a FULL-TIME shift");
					break;
				case PART_TIME:
					empWorkHrs += c.getHalfDayShiftHrs();
					empDailyWage += c.wagePerHour * c.getHalfDayShiftHrs();
					System.out.println("Day " + workDayCount + ": The Employee is a PART-TIME shift");
					break;
				default:
					System.out.println("Day " + workDayCount + ": The Employee is absent");
				}
			}
		}

		emp.setMonthlyWageAmt(empDailyWage);

		System.out.println("The person's monthly wage is " + empDailyWage);
	}
}
