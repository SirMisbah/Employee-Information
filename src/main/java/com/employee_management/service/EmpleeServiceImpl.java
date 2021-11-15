package com.employee_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee_management.model.Employee;
import com.employee_management.repository.EmployeeRepo;

@Service
public class EmpleeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}
	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepo.save(employee);
		
	}
	@Override
	public Employee getEmployeeById(int id) {
		Optional<Employee> optional = employeeRepo.findById(id);
		Employee employee= null;
		if(optional.isPresent()) {
			employee=optional.get();
		}
		else {throw new RuntimeException("Employee not found for id::" + id);}
		return employee;
	}
	@Override
	public void deleteEmployeeById(int id) {
		this.employeeRepo.deleteById(id);
		
	}

}
