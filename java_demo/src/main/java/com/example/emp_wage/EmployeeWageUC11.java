package com.example.emp_wage;

import com.example.emp_wage.models.Company;
import com.example.emp_wage.models.Employee1;
import com.example.emp_wage.services.EmployeeWageBuilder;

//EmployeeWage class
public class EmployeeWageUC11 {
	public static void main(String[] args) {

		EmployeeWageBuilder employeeWageBuilder = new EmployeeWageBuilder();

		// Initialize the company object with the parameters;
		Company c1 = employeeWageBuilder.getDetails(20, 20, 100, 8, 4);
		Company c2 = employeeWageBuilder.getDetails(30, 25, 120, 10, 5);

		Employee1 employee = new Employee1();
		employeeWageBuilder.initialize(employee, new Company[] { c1, c2 });

		// Pass the company object as argument to the class method
		employeeWageBuilder.EmployeeWageCalculator(employee);
	}
}
