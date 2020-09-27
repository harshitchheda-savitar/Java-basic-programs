package com.example.emp_wage.models;

import java.util.List;

public class Employee2 extends Employee {

	private List<Company> companyList;

	public List<Company> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<Company> companyList) {
		this.companyList = companyList;
	}

}
