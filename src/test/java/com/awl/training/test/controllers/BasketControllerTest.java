package com.awl.training.test.controllers;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.startsWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

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
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.awl.training.WebshopBoot;

@RunWith(SpringJUnit4ClassRunner.class)
@WebIntegrationTest
@SpringApplicationConfiguration(classes = WebshopBoot.class)
public class BasketControllerTest {

	private static String ROOT_CONTEXT = "/basket";

	private static String SESSION_ID_KEY = "sessionId";
	private static String PRODUCT_ID_KEY = "productId";
	private static String QUANTITY_KEY = "quantity";

	private static String SESSION_ID_VALUE = UUID.randomUUID().toString();
	private static String SESSION_ID_VALUE_EMPTY = "empty";

	@Autowired
	private WebApplicationContext webApplicationContext;

	protected MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testGetBasket() throws Exception {
		MockHttpServletRequestBuilder request = get(ROOT_CONTEXT + "/" + SESSION_ID_VALUE_EMPTY);

		ResultActions result = mockMvc.perform(request);
		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$.sessionId", notNullValue()));
		result.andExpect(jsonPath("$.items", empty()));
	}

	@Test
	public void testAddBasketOk() throws Exception {
		MockHttpServletRequestBuilder request = post(ROOT_CONTEXT + "/add");
		request.param(SESSION_ID_KEY, SESSION_ID_VALUE);
		request.param(PRODUCT_ID_KEY, "1");
		request.param(QUANTITY_KEY, "99999999");

		ResultActions result = mockMvc.perform(request);

		result.andDo(MockMvcResultHandlers.print());

		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$", startsWith("The Item  [1] has been successfully added in basket [" + SESSION_ID_VALUE + "]")));

	}

}
