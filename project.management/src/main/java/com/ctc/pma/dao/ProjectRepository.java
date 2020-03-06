package com.ctc.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ctc.pma.dto.ChartData;
import com.ctc.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long>{

	@Query(nativeQuery=true,value="Select stage as label,COUNT(*) as value " + 
			"FROM project " + 
			"GROUP BY stage")
	public List<ChartData> getProjectStatus();
	
	
	@Override
	public List<Project> findAll();
}
