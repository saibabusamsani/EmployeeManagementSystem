package com.jsp.model;

public class Employee {
	private int empId;
	private String empName;
	private double empSalary;
	private int empdeptno;
	public Employee()
	{
		
	}
	public Employee(int empId, String empName, double empSalary, int empdeptno) {
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		this.empdeptno = empdeptno;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	public int getEmpdeptno() {
		return empdeptno;
	}
	public void setEmpdeptno(int empdeptno) {
		this.empdeptno = empdeptno;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + ", empdeptno="
				+ empdeptno + "]";
	}
	
	
	
	

}
