package com.emp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.Repositories.IEmployeeRepository;
import com.emp.entity.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeRepository empRepo;

	@Override
	public Integer saveEmployee(Employee emp) {
		Employee savedEmployee = empRepo.save(emp);
		return savedEmployee.getId();
	}

	@Override
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}

}
