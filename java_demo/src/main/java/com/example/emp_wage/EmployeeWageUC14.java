package com.example.emp_wage;

import java.util.ArrayList;
import java.util.List;

import com.example.emp_wage.models.Company;
import com.example.emp_wage.models.Employee3;
import com.example.emp_wage.services.EmployeeWageBuilder;

//EmployeeWage class
public class EmployeeWageUC14 {
	public static void main(String[] args) {

		EmployeeWageBuilder employeeWageBuilder = new EmployeeWageBuilder();

		// Initialize the company object with the parameters;
		Company c1 = employeeWageBuilder.getDetails("jio",20, 20, 100, 8, 4);
		Company c2 = employeeWageBuilder.getDetails("tata",30, 25, 120, 10, 5);

		Employee3 employee = new Employee3();
		List<Company> companyList = new ArrayList<>();
		companyList.add(c1);
		companyList.add(c2);
		employeeWageBuilder.initialize(employee, companyList);

		// Pass the company object as argument to the class method
		employeeWageBuilder.EmployeeCompanyWiseCalculator(employee);
		
		//get totalWage for a particular company
		System.out.println("Employee wage for company :" + employee.getCompanyEmployeeWageMapping().get("maha"));
	}
}
