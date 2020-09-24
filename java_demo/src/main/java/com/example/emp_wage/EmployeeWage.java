package com.example.emp_wage;

import java.util.Random;

public class EmployeeWage {
	public static void main(String[] args) {
		Random random = new Random();
		final int PRESENT = 1;
		
		int isPresent = random.nextInt(2);
		if(isPresent == PRESENT)
			System.out.println("Employee is Present");
		else
			System.out.println("Employee is absent");
	}
}
