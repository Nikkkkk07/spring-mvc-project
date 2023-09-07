package com.example.Employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Employee.model.Employee;
import com.example.Employee.service.EmployeeService;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees()
	{
		return employeeService.fetchAllEmployees();
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id)
	{
		Employee e=employeeService.getEmployeeById(id);
		ResponseEntity<Employee> re=new ResponseEntity<Employee>(e, HttpStatus.OK);
		return re;
	}
	
	@PostMapping("/employees")
	public Employee insertEmployee(@Valid @RequestBody Employee employee)
	{
		System.out.println(employee);
		return employeeService.insertEmployee(employee);
	}
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee)
	{
		return employeeService.updateEmployee(employee);
	}
	@DeleteMapping("/employees/{id}")
	public String deleteEmployeeById(@PathVariable("id") int id)
	{
		return employeeService.deleteEmployeeById(id);
	}
}


