package com.xm.dao;

import org.springframework.data.repository.CrudRepository;

import com.xm.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
