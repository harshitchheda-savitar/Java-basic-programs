package com.example.emp_wage.models;

import java.util.List;

public class Employee {
	private int monthlyWageAmt;
	private List<Integer> dailyWage;

	public int getMonthlyWageAmt() {
		return monthlyWageAmt;
	}

	public void setMonthlyWageAmt(int monthlyWageAmt) {
		this.monthlyWageAmt = monthlyWageAmt;
	}

	public List<Integer> getDailyWage() {
		return dailyWage;
	}

	public void setDailyWage(List<Integer> dailyWage) {
		this.dailyWage = dailyWage;
	}

}
