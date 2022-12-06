package com.emp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emp.entity.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer>{

}
