package com.example.emp_wage;

import java.util.Random;

public class EmployeeWage {
	public static void main(String[] args) {
		Random random = new Random();
		final int FULL_TIME = 1;
		final int PART_TIME = 2;
		final int WAGE_PER_HOUR = 20;
		final int FULL_DAY_HOUR = 8;
		final int HALF_DAY_HOUR = 4;
		
		int empStatus = random.nextInt(3);
		int empDailyWage;
		if(empStatus == FULL_TIME) {
			empDailyWage = WAGE_PER_HOUR * FULL_DAY_HOUR;
			System.out.println("The Employee is a FULL-TIME employee");
		}
		else if(empStatus == PART_TIME) {
			empDailyWage = WAGE_PER_HOUR * HALF_DAY_HOUR;
			System.out.println("The Employee is a PART-TIME employee");
		}
		else {
			empDailyWage = 0;
			System.out.println("The Employee is absent");
		}
			
		System.out.println("The person's daily wage is " + empDailyWage);	
	}
}
