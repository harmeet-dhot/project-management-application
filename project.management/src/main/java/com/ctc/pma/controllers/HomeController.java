package com.ctc.pma.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ctc.pma.dao.EmployeeRepository;
import com.ctc.pma.dao.ProjectRepository;
import com.ctc.pma.dto.ChartData;
import com.ctc.pma.dto.EmployeeProject;
import com.ctc.pma.entities.Employee;
import com.ctc.pma.entities.Project;
import com.ctc.pma.services.EmployeeService;
import com.ctc.pma.services.ProjectService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class HomeController {

	@Value("${version}")
	private String ver;
	
	@Autowired
	ProjectService proService;
	@Autowired
	EmployeeService empService;
	
	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		Map<String,Object> map=new HashMap<>();
		
		model.addAttribute("versionNumber", ver);
	    List<Project> projectList=proService.getAll();
	    model.addAttribute("projectList",projectList);
	    
	   List<ChartData> projectData=proService.getProjectStatus(); 
	    //Convert this into JSON
	    ObjectMapper objmapper =new ObjectMapper();
	    String jsonString=objmapper.writeValueAsString(projectData);
	    model.addAttribute("projectStatusCnt", jsonString);
	    
	    List<EmployeeProject> employeesProjectCount=empService.employeeProjects();
	    model.addAttribute("employeesProjectCount",employeesProjectCount);
	    return "main/home";
	}
}
 