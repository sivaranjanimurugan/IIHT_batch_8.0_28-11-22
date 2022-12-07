package com.emp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emp.entity.Employee;
import com.emp.services.IEmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;

	@PostMapping("/addEmployee")
	public Integer createEmployee(@RequestBody Employee employee) {
		Integer id = employeeService.saveEmployee(employee);
		return id;
	}

	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/get-employee/{id}")
	public Optional<Employee> getEmployee(@PathVariable Integer id) {
		return employeeService.getEmployeeById(id);
	}

	@DeleteMapping("/del-employee/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable Integer id) {
		try {
			employeeService.deleteEmployee(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
