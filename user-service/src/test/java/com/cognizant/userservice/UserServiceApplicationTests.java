package com.cognizant.userservice;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
//import org.springframework.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.cognizant.userservice.controller.TrainingController;
import com.cognizant.userservice.model.Training;
import com.cognizant.userservice.service.TrainingService;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder
@AutoConfigureMockMvc
public class UserServiceApplicationTests {

	@Autowired
	TrainingService trainingService;

	@Mock
	TrainingController trainingController;

	@Autowired
	private MockMvc mvc;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	// Service
	@Test
	public void testGetPendingList() {
		List<Training> trList = new ArrayList<>();
		trList = trainingService.getPendingList("pallavi");
		assertEquals(trList.isEmpty(), true);
	}

	// Controller
	@Test
	// @WithMockUser
	public void testGetAllTrainingList() throws Exception {
		ResultActions actions = mvc.perform(get("/proposal"));
		actions.andExpect(status().isOk());

	}

}
