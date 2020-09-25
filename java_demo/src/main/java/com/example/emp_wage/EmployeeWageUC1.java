package com.example.emp_wage;

import java.util.Random;

//EmployeeWage class
public class EmployeeWageUC1 {
	public static void main(String[] args) {
		Random random = new Random();
		final int PRESENT = 1;

		// Generate random number for the employee status
		int isPresent = random.nextInt(2);
		// check the condition for his presence
		if (isPresent == PRESENT)
			System.out.println("Employee is Present");
		else
			System.out.println("Employee is absent");
	}
}