package com.ctc.pma.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)					
	
	private long employee_id;
	private String first_name;
	private String last_name;
	private String email;
	
	@ManyToMany(cascade= {CascadeType.DETACH,CascadeType.REFRESH,CascadeType.PERSIST},
			fetch=FetchType.LAZY)
	@JoinTable(name="project_employee",
    joinColumns=@JoinColumn(name="employee_id"),
    inverseJoinColumns = @JoinColumn(name="project_id"))
    private List<Project> projects;
	

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Employee() {
		 
	}
	
	public Employee(String firstName, String lastName, String email) {
		super();
		this.first_name = firstName;
		this.last_name = lastName;
		this.email = email;
	}
	
	
	public long getEmployeeID() {
		return employee_id;
	}
	public void setEmployeeID(long employeeID) {
		this.employee_id = employeeID;
	}
	public String getFirstName() {
		return first_name;
	}
	public void setFirstName(String firstName) {
		this.first_name = firstName;
	}
	public String getLastName() {
		return last_name;
	}
	public void setLastName(String lastName) {
		this.last_name = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
