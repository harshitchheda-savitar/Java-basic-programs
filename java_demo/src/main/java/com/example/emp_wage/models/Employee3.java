package com.example.emp_wage.models;

import java.util.Map;

public class Employee3 extends Employee2{

	private Map<String,Integer> companyEmployeeWageMapping;

	public Map<String, Integer> getCompanyEmployeeWageMapping() {
		return companyEmployeeWageMapping;
	}

	public void setCompanyEmployeeWageMapping(Map<String, Integer> companyEmployeeWageMapping) {
		this.companyEmployeeWageMapping = companyEmployeeWageMapping;
	}
	
	
}
