package com.cognizant.authenticationservice;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.cognizant.authenticationservice.model.Mentor;
import com.cognizant.authenticationservice.controller.UserController;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthenticationServiceApplicationTests {

	@Mock
	UserController userController;

	@Autowired
	private MockMvc mvc;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getMentor() {

		Mentor mentorNew = new Mentor();
		mentorNew.setUserID("John");
		mentorNew.setContactNo("8806756798");
		mentorNew.setEmail("john@email.com");
		mentorNew.setYearsOfExperience(10f);
		mentorNew.setFirstName("john");
		mentorNew.setLastName("mathew");
		mentorNew.setLinkedInUrl("john@linked.com");
		mentorNew.setPassword("pwd");
		mentorNew.setId(5L);

		List<Mentor> mentorList = new ArrayList<>();
		mentorList.add(mentorNew);
		when(userController.getMentors()).thenReturn(mentorList);

		// test
		List<Mentor> testMentor = userController.getMentors();
		assertEquals(1, testMentor.size());
		for (Mentor mentors : testMentor) {
			assertEquals("john", mentors.getFirstName());
		}

		verify(userController).getMentors();

	}

}
