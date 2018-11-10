package com.xm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xm.dao.EmployeeRepository;
import com.xm.entity.Employee;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@RequestMapping(value = "/employee/get", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<Employee> getEmployees() {

		return (List<Employee>) employeeRepository.findAll();
	}

	@RequestMapping(value = "/employee/search/{empNo}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Employee searchEmployee(@PathVariable("empNo") String empNo) {
		return employeeRepository.findOne(Long.parseLong(empNo));
	}

	@RequestMapping(value = "/employee/add", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Employee addEmployee(@RequestBody Employee emp) {

		try {
			employeeRepository.save(emp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return emp;
	}

	@RequestMapping(value = "/employee/delete/{empNo}", method = RequestMethod.DELETE)
	@ResponseBody
	public Employee deleteEmployee(@PathVariable("empNo") String empNo) {
		
		Employee emp = employeeRepository.findOne(Long.parseLong(empNo));
		
		try {
			employeeRepository.delete(Long.parseLong(empNo));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return emp;
	}
}
