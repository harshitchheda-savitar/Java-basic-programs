package com.example.emp_wage;

import java.util.ArrayList;
import java.util.List;

import com.example.emp_wage.models.Company;
import com.example.emp_wage.models.Employee2;
import com.example.emp_wage.services.EmployeeWageBuilder;

//EmployeeWage class
public class EmployeeWageUC12 {
	public static void main(String[] args) {

		EmployeeWageBuilder employeeWageBuilder = new EmployeeWageBuilder();

		// Initialize the company object with the parameters;
		Company c1 = employeeWageBuilder.getDetails(20, 20, 100, 8, 4);
		Company c2 = employeeWageBuilder.getDetails(30, 25, 120, 10, 5);

		Employee2 employee = new Employee2();
		List<Company> companyList = new ArrayList<>();
		companyList.add(c1);
		companyList.add(c2);
		employeeWageBuilder.initialize(employee, companyList);

		// Pass the company object as argument to the class method
		employeeWageBuilder.EmployeeWageCalculator(employee,false);
	}
}
