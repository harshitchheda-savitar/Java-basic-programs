package com.example.emp_wage;

import java.util.Random;

public class EmployeeWage {
	public static void main(String[] args) {
		Random random = new Random();
		final int PRESENT = 1;
		final int WAGE_PER_HOUR = 20;
		final int FULL_DAY_HOUR = 8;
		
		int isPresent = random.nextInt(2);
		int empDailyWage;
		if(isPresent == PRESENT)
			empDailyWage = WAGE_PER_HOUR * FULL_DAY_HOUR;
		else
			empDailyWage = 0;
			
		System.out.println("Employee was " + (isPresent == PRESENT ? "PRESENT" : "ABSENT") + " so the person's daily wage is " + empDailyWage);	
	}
}
