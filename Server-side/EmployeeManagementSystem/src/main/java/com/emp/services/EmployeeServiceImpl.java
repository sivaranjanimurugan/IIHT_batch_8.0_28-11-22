package com.emp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.entity.Employee;
import com.emp.exception.ResourceNotFoundExceptionHandler;
import com.emp.repository.IEmployeeRepository;

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

	@Override
	public Optional<Employee> getEmployeeById(Integer id) {
		return empRepo.findById(id);
	}

	@Override
	public void deleteEmployee(Integer id) {
		empRepo.deleteById(id);
	}

	@Override
	public Employee updateEmployee(Employee employee, Integer id) {
		// throw exception if the resource not found
		Employee existingEmployee = empRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExceptionHandler("Employee", "id", id));
		// update existing object
		existingEmployee.setEname(employee.getEname());
		existingEmployee.setEposition(employee.getEposition());
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setSalary(employee.getSalary());
		//return updated employee object
		return empRepo.save(existingEmployee);
	}

}
