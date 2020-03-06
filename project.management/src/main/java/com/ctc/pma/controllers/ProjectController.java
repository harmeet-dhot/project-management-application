package com.ctc.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ctc.pma.dao.EmployeeRepository;
import com.ctc.pma.dao.ProjectRepository;
import com.ctc.pma.entities.Employee;
import com.ctc.pma.entities.Project;
import com.ctc.pma.services.EmployeeService;
import com.ctc.pma.services.ProjectService;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	@Autowired
	ProjectService proService;
	@Autowired
	EmployeeService empService;
	
	@GetMapping
	public String displayProjects(Model model) {
		List<Project> projects=proService.getAll();
		model.addAttribute("projects",projects );
		return "projects/list-projects";
		
	}
	
    @GetMapping("/new")
	public String displayProjectForm(Model model) {
    	Project aProject=new Project();
    	List<Employee> employees=empService.getAll();
    	model.addAttribute("project",aProject);
    	model.addAttribute("allEmployees",employees);
		return "projects/new-project";
	}
    @PostMapping("/save")
	public String createProject(Project project,Model model) {
    	proService.save(project);
    	
    	
		return "redirect:/projects";
	}
}
