
package com.example.emp_wage;

import java.util.Random;

//EmployeeWage class
public class EmployeeWageUC4 {
	public static void main(String[] args) {
		Random random = new Random();
		// Declare static content
		final int FULL_TIME = 1;
		final int PART_TIME = 2;
		final int WAGE_PER_HOUR = 20;
		final int FULL_DAY_HOUR = 8;
		final int HALF_DAY_HOUR = 4;

		// Generate a random number for the employee shift type
		int empStatus = random.nextInt(3);
		int empDailyWage;

		// Use a switch case for deciding the daily wage based of shift type
		switch (empStatus) {
		case FULL_TIME:
			empDailyWage = WAGE_PER_HOUR * FULL_DAY_HOUR;
			System.out.println("The Employee is a FULL-TIME employee");
			break;
		case PART_TIME:
			empDailyWage = WAGE_PER_HOUR * HALF_DAY_HOUR;
			System.out.println("The Employee is a PART-TIME employee");
			break;
		default:
			empDailyWage = 0;
			System.out.println("The Employee is absent");
		}

		System.out.println("The person's daily wage is " + empDailyWage);
	}
}