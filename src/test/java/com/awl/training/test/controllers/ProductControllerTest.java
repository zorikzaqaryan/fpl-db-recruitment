package com.awl.training.test.controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.awl.training.WebshopBoot;

@RunWith(SpringJUnit4ClassRunner.class)
@WebIntegrationTest
@SpringApplicationConfiguration(classes = WebshopBoot.class)
public class ProductControllerTest {

	private static String ROOT_CONTEXT = "/product";

	@Autowired
	private WebApplicationContext webApplicationContext;

	protected MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testGetProducts() throws Exception {
		MockHttpServletRequestBuilder request = get(ROOT_CONTEXT + "/all");

		ResultActions result = mockMvc.perform(request);
		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$", hasSize(100)));
		result.andExpect(jsonPath("$[0].id", is(0)));
		result.andExpect(jsonPath("$[0].title", is("Product 0")));
		result.andExpect(jsonPath("$[0].description", notNullValue()));
		result.andExpect(jsonPath("$[0].price", notNullValue()));
		result.andExpect(jsonPath("$[0].fee", notNullValue()));
		result.andExpect(jsonPath("$[0].stock", notNullValue()));
	}

}
