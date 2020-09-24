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
		final int WORKING_DAYS_IN_MONTH = 20;
		final int TOTAL_WORKING_HOURS = 100;
		
		int empDailyWage = 0;
		int workDayCount = 0;
		int empWorkHrs = 0;
		
		while((workDayCount < WORKING_DAYS_IN_MONTH) && (empWorkHrs < TOTAL_WORKING_HOURS)) {
			int empStatus = random.nextInt(3);
			++workDayCount;
			switch(empStatus) {
			case FULL_TIME:
				empWorkHrs += FULL_DAY_HOUR;
				empDailyWage += WAGE_PER_HOUR * FULL_DAY_HOUR;
				System.out.println("Day " + workDayCount +": The Employee is a FULL-TIME shift");
				break;
			case PART_TIME:
				empWorkHrs += HALF_DAY_HOUR;
				empDailyWage += WAGE_PER_HOUR * HALF_DAY_HOUR;
				System.out.println("Day " + workDayCount +": The Employee is a PART-TIME shift");
				break;
			default :
				System.out.println("Day " + workDayCount +": The Employee is absent");
			}
		}
		
		
		System.out.println("The person's monthly wage is " + empDailyWage);	
	}
}
