package com.training.spring;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestOperations;
import org.springframework.web.context.WebApplicationContext;

import com.training.spring.rest.MyRest;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@Profile("test")
@AutoConfigureMockMvc
public class SpringbootApplicationTests {

	@Autowired
	private MyRest myRest;

	@Autowired
	private RestOperations restOp;

	// @Autowired
	// private MockMvc mockMvc;

	@LocalServerPort
	private int port;

	// @Autowired
	// private WebApplicationContext wac;

	@Before
	public void beforeTest() {
		// mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void test_MyRest_method1_senaryo1() {
		String resp = myRest.method1();
		assertEquals("My implementation2", resp);
	}

	@Test
	public void test_MyRest_method1_senaryo2() {
		String resp = restOp.getForObject("http://localhost:" + port + "/test/user/test", String.class);
		assertEquals("My implementation2", resp);
	}

	// @Test
	// public void test_MyRest_method1_senaryo3() throws Exception {
	//
	// mockMvc.perform(MockMvcRequestBuilders.get("/test/user/test")).andDo(MockMvcResultHandlers.print())
	// .andExpect(MockMvcResultMatchers.status().isOk())
	// .andExpect(MockMvcResultMatchers.content().string(org.hamcrest.Matchers.containsString("OK")));
	//
	// }

	@Test
	public void contextLoads() {
	}

}
