package com.ctc.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import com.ctc.pma.Application;
import com.ctc.pma.dao.ProjectRepository;
import com.ctc.pma.entities.Project;

@ContextConfiguration(classes=Application.class)
@RunWith(SpringRunner.class)
@DataJpaTest
@SqlGroup({@Sql(executionPhase=ExecutionPhase.BEFORE_TEST_METHOD,scripts= {"classpath:schema.sql","classpath:data.sql"}),
	@Sql(executionPhase=ExecutionPhase.AFTER_TEST_METHOD,scripts= "classpath:drop.sql")})
public class ProjectRepositoryIntegrationTest {
   
	@Autowired
	ProjectRepository proRepo;
	
	@Test
	public void ifNewProjectSaved_thenSuccess() {
		Project newProject=new Project("New project","COMPLETE","TEST DESCRIPTION");
		proRepo.save(newProject);
		
		assertEquals(5,proRepo.findAll().size());
	}
}
