package com.ctc.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ctc.pma.dao.EmployeeRepository;
import com.ctc.pma.entities.Employee;
import com.ctc.pma.entities.Project;
import com.ctc.pma.services.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	EmployeeService empService;
	
	@GetMapping
	public String displayEmployees(Model model) {
		List<Employee> employees=empService.getAll();
		model.addAttribute("employees",employees );
		return "employees/list-employees";
		
	}
	
	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
    	Employee aEmployee=new Employee();
		model.addAttribute("employee",aEmployee);
		return "employees/new-employee";
	}
    
    @PostMapping("/save")
    public String createEmployee(Employee employee,Model model) {
    	empService.save(employee);
    	return "redirect:/employees";
    }
	
}
