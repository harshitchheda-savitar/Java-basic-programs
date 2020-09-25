package com.example.emp_wage;

import java.util.Random;

//EmployeeWage class
public class EmployeeWageUC5 {
	public static void main(String[] args) {
		Random random = new Random();
		// Declare static content
		final int FULL_TIME = 1;
		final int PART_TIME = 2;
		final int WAGE_PER_HOUR = 20;
		final int FULL_DAY_HOUR = 8;
		final int HALF_DAY_HOUR = 4;
		final int WORKING_DAYS_IN_MONTH = 20;

		int empDailyWage = 0;

		// Iterate for each working day
		for (int n = 1; n <= WORKING_DAYS_IN_MONTH; n++) {
			// Generate a random number for the employee shift status for each working day
			int empStatus = random.nextInt(3);
			// Calculate the dailyWage for each day depending on the shift type and finally
			// calculate the final monthly wage based on sum of each days wage
			switch (empStatus) {
			case FULL_TIME:
				empDailyWage += WAGE_PER_HOUR * FULL_DAY_HOUR;
				System.out.println("Day " + n + ": The Employee is a FULL-TIME employee");
				break;
			case PART_TIME:
				empDailyWage += WAGE_PER_HOUR * HALF_DAY_HOUR;
				System.out.println("Day " + n + ": The Employee is a PART-TIME employee");
				break;
			default:
				empDailyWage += 0;
				System.out.println("Day " + n + ": The Employee is absent");
			}
		}

		System.out.println("The person's monthly wage is " + empDailyWage);
	}
}