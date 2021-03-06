package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.configuration.Config;
import com.revature.models.Category;
import com.revature.models.Curriculum;
import com.revature.models.Skill;
import com.revature.repositories.CurriculumDao;


@ExtendWith(MockitoExtension.class)
public class CurriculumServiceImplTests {

	@Mock
	private CurriculumDao cd;
	
	@Mock
	private Config config;
	
	@InjectMocks
	private CurriculumServiceImpl categoryService;
	
	@Test
	public void testGetAllCurriculum() {
		List<Curriculum> mockAllCurriculum = new ArrayList<>();
		mockAllCurriculum.add(new Curriculum(1, "Curriculum1", new ArrayList<Skill>()));
		mockAllCurriculum.add(new Curriculum(2, "Curriculum2", new ArrayList<Skill>()));
		
		when(cd.findAll()).thenReturn(mockAllCurriculum);
		
		assertEquals(2, categoryService.getAllCurriculum().size());
		assertEquals("Curriculum1", categoryService.getAllCurriculum().get(0).getCurriculumName());
	}
	
	@Test
	public void testCreateCurriculum() {
		List<Skill> skills = new ArrayList<>();
		skills.add(new Skill(1, "skill1", new Category(1, "cat1")));
		Curriculum mockCurriculum = new Curriculum(1, "Curriculum1", skills);
		
		when(config.getCategories()).thenReturn(12);
		when(cd.save(Mockito.any(Curriculum.class))).thenReturn(mockCurriculum);
		
		assertEquals(mockCurriculum, categoryService.createCurriculum(mockCurriculum));
	}
}
