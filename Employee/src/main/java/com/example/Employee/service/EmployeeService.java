package com.example.Employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Employee.exception.EmployeeIdNotFoundException;
import com.example.Employee.model.Employee;
import com.example.Employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	public List<Employee> fetchAllEmployees()
	{
		return employeeRepository.findAll();
	}
	
	public Employee getEmployeeById(int id)
	{
		Optional<Employee> op=employeeRepository.findById(id);
		if(op.isPresent())
			return op.get();
		else
			throw new EmployeeIdNotFoundException("No Employee found with Id:"+id);
	}
	
	public Employee insertEmployee(Employee employee)
	{
		return employeeRepository.save(employee);
	}
	
	public Employee updateEmployee(Employee employee)
	{
		if(employeeRepository.existsById(employee.getEmployeeId()))
			return employeeRepository.save(employee);
		else
			throw new EmployeeIdNotFoundException("No Employee found with Id:"+employee.getEmployeeId());
	}
	
	public String deleteEmployeeById(int id)
	{
		if(employeeRepository.existsById(id))
		{
		employeeRepository.deleteById(id);
			return "Deleted Successfully!!!";
		}
		else
			throw new EmployeeIdNotFoundException("No Employee found with Id:"+id);
	}
}
