package com.example.emp_wage.interfaces;

import java.util.List;

import com.example.emp_wage.models.Company;
import com.example.emp_wage.models.Employee1;
import com.example.emp_wage.models.Employee2;

public interface EmployeeWageInterface1 {

	public void initialize(Employee1 employee, Company[] companyList);

	public void initialize(Employee2 employee, List<Company> companyList);
}
