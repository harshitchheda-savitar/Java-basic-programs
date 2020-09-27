package com.example.emp_wage;

import java.util.Random;

//EmployeeWage class
public class EmployeeWageUC9 {
	// Declare static content
	static final int FULL_TIME = 1;
	static final int PART_TIME = 2;
	static final int FULL_DAY_HOUR = 8;
	static final int HALF_DAY_HOUR = 4;

	public static void main(String[] args) {
		EmployeeWageUC9 employeeWage = new EmployeeWageUC9();
		// Initialize the company object with the parameters;
		Company company = employeeWage.new Company();
		company.setName("adani");
		company.setTotalWorkingHours(100);
		company.setWagePerHour(20);
		company.setWorkingDaysInMonth(20);

		// Initialize the employee object with the parameters
		EmployeeWageBuilder employee = employeeWage.new EmployeeWageBuilder();

		// Pass the company object as argument to the class method
		EmployeeWageCalculator(company,employee);
	}

	// Class-method
	public static void EmployeeWageCalculator(Company c, EmployeeWageBuilder emp) {
				
		Random random = new Random();

		// Initialize the local variables
		int empDailyWage = 0;
		int workDayCount = 0;
		int empWorkHrs = 0;

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
				empWorkHrs += FULL_DAY_HOUR;
				empDailyWage += c.wagePerHour * FULL_DAY_HOUR;
				System.out.println("Day " + workDayCount + ": The Employee is a FULL-TIME shift");
				break;
			case PART_TIME:
				empWorkHrs += HALF_DAY_HOUR;
				empDailyWage += c.wagePerHour * HALF_DAY_HOUR;
				System.out.println("Day " + workDayCount + ": The Employee is a PART-TIME shift");
				break;
			default:
				System.out.println("Day " + workDayCount + ": The Employee is absent");
			}
		}
		
		emp.setEmpWorkHrs(empWorkHrs);
		emp.setMonthlyWageAmt(empDailyWage);
		emp.setWorkDayCount(workDayCount);
		
		System.out.println("The person's monthly wage is " + empDailyWage);
	}

	// Create a company class with the instance variables
	public class Company {
		private String name;
		private int wagePerHour;
		private int workingDaysInMonth;
		private int totalWorkingHours;

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

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

	public class EmployeeWageBuilder {
		private int monthlyWageAmt;
		private int empWorkHrs;
		private int workDayCount;

		public int getMonthlyWageAmt() {
			return monthlyWageAmt;
		}

		public void setMonthlyWageAmt(int monthlyWageAmt) {
			this.monthlyWageAmt = monthlyWageAmt;
		}

		public int getEmpWorkHrs() {
			return empWorkHrs;
		}

		public void setEmpWorkHrs(int empWorkHrs) {
			this.empWorkHrs = empWorkHrs;
		}

		public int getWorkDayCount() {
			return workDayCount;
		}

		public void setWorkDayCount(int workDayCount) {
			this.workDayCount = workDayCount;
		}

	}
}
