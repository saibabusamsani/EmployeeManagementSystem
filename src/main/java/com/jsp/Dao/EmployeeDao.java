package com.jsp.Dao;

import java.util.List;

import com.jsp.model.Employee;

public interface EmployeeDao {
	List<Employee> getAllEmployee();
	List<Employee> getEmployeeDetailesBySalOrDeptno(int deptno);
	Employee getEmployeeById(int id);
	int updateEmployeeDetailes(Employee employee);
	int deleteEmployeeById(int id);
	int addEmployee(Employee employee);
}
