package com.cognizant.searchservice;

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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.cognizant.searchservice.controller.SearchController;
import com.cognizant.searchservice.model.MentorSkills;
import com.cognizant.searchservice.service.SearchService;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder
@AutoConfigureMockMvc
public class SearchServiceApplicationTests {

	@Autowired
	SearchService searchService;

	@Mock
	SearchController searchController;

	@Autowired
	private MockMvc mvc;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetAll() {
		List<MentorSkills> msList = new ArrayList<>();
		msList = searchService.getAll();
		assertEquals(msList.isEmpty(), false);
	}

	// Controller
	@Test
	public void testGetAllSearch() throws Exception {
		ResultActions actions = mvc.perform(get("/search"));
		actions.andExpect(status().isOk());

	}

}
