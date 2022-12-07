package com.emp.services;

import java.util.List;
import java.util.Optional;

import com.emp.entity.Employee;

public interface IEmployeeService {

	public Integer saveEmployee(Employee emp);

	public List<Employee> getAllEmployees();

	public Optional<Employee> getEmployeeById(Integer id);
	
	public void deleteEmployee(Integer id);
	
	public Employee updateEmployee(Employee employee, Integer id);

}
