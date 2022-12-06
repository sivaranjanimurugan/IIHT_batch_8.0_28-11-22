package com.emp.services;

import java.util.List;

import com.emp.entity.Employee;

public interface IEmployeeService {

	public Integer saveEmployee(Employee emp);

	public List<Employee> getAllEmployees();

}
