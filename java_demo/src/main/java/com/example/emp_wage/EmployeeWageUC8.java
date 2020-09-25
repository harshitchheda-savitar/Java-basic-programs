package com.example.emp_wage;

import java.util.Random;

//EmployeeWage class
public class EmployeeWageUC8 {
	// Declare static content
	static final int FULL_TIME = 1;
	static final int PART_TIME = 2;
	static final int FULL_DAY_HOUR = 8;
	static final int HALF_DAY_HOUR = 4;

	public static void main(String[] args) {
		EmployeeWageUC8 employee = new EmployeeWageUC8();
		// Initialize the company object with the parameters;
		Company c1 = employee.new Company(20, 20, 100);
		Company c2 = employee.new Company(25, 30, 120);
		// Pass the company object as argument to the class method
		EmployeeWageCalculator(c1);
		System.out.println();
		EmployeeWageCalculator(c2);
	}

	// Class-method
	public static void EmployeeWageCalculator(Company c) {
		Random random = new Random();
		// Initialize the local variables
		int empDailyWage = 0;
		int workDayCount = 0;
		int empWorkHrs = 0;

		// Iterate till the working-month is over or the employee-monthly working hours
		// are fulfilled
		while ((workDayCount < c.workingDaysInMonth) && (empWorkHrs < c.totalWorkingHours)) {
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

		System.out.println("The person's monthly wage is " + empDailyWage);
	}

	// Create a company class with the instance variables
	public class Company {
		int wagePerHour;
		int workingDaysInMonth;
		int totalWorkingHours;

		public Company(int wagePerHour, int workingDaysInMonth, int totalWorkingHours) {
			this.wagePerHour = wagePerHour;
			this.totalWorkingHours = totalWorkingHours;
			this.workingDaysInMonth = workingDaysInMonth;
		}
	}
}
