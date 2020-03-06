package com.ctc.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctc.pma.dao.EmployeeRepository;
import com.ctc.pma.dto.EmployeeProject;
import com.ctc.pma.entities.Employee;
@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository empRepo;
	
	
	public Employee save(Employee employee) {
		return empRepo.save(employee);
	}


	public List<Employee> getAll() {
		return empRepo.findAll();
	}


	public List<EmployeeProject> employeeProjects() {
		return empRepo.employeeProjects();
	}
}
