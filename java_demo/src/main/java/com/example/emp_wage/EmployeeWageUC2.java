package com.example.emp_wage;

import java.util.Random;

//EmployeeWage class
public class EmployeeWageUC2 {
	public static void main(String[] args) {
		Random random = new Random();
		// Declare the static content
		final int PRESENT = 1;
		final int WAGE_PER_HOUR = 20;
		final int FULL_DAY_HOUR = 8;

		// Generate a random number for employee status
		int isPresent = random.nextInt(2);
		int empDailyWage;
		// Check of the status of the employee and compute the daily wage
		if (isPresent == PRESENT)
			empDailyWage = WAGE_PER_HOUR * FULL_DAY_HOUR;
		else
			empDailyWage = 0;

		System.out.println("Employee was " + (isPresent == PRESENT ? "PRESENT" : "ABSENT")
				+ " so the person's daily wage is " + empDailyWage);
	}
}