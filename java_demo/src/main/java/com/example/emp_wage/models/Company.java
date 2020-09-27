package com.example.emp_wage.models;

public class Company {

	private String companyName;
	private int wagePerHour;
	private int workingDaysInMonth;
	private int totalWorkingHours;
	private int fullDayShiftHrs;
	private int halfDayShiftHrs;

	public int getWagePerHour() {
		return wagePerHour;
	}

	public void setWagePerHour(int wagePerHour) {
		this.wagePerHour = wagePerHour;
	}

	public int getWorkingDaysInMonth() {
		return workingDaysInMonth;
	}

	public void setWorkingDaysInMonth(int workingDaysInMonth) {
		this.workingDaysInMonth = workingDaysInMonth;
	}

	public int getTotalWorkingHours() {
		return totalWorkingHours;
	}

	public void setTotalWorkingHours(int totalWorkingHours) {
		this.totalWorkingHours = totalWorkingHours;
	}

	public int getFullDayShiftHrs() {
		return fullDayShiftHrs;
	}

	public void setFullDayShiftHrs(int fullDayShiftHrs) {
		this.fullDayShiftHrs = fullDayShiftHrs;
	}

	public int getHalfDayShiftHrs() {
		return halfDayShiftHrs;
	}

	public void setHalfDayShiftHrs(int halfDayShiftHrs) {
		this.halfDayShiftHrs = halfDayShiftHrs;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
