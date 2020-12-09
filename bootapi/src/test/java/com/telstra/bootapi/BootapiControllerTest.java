package com.telstra.bootapi;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.telstra.bootapi.models.JRequest;

public class BootapiControllerTest extends AbstractTest {
	@Autowired
	Utils testUtils;

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void testCreateJRequest() throws Exception {
		System.out.println("Running createJRequest Test*******");
		String uri = "/jreq/";
		JRequest jRequest = new JRequest();
		jRequest.set_id(testUtils.assignJReqID());
		jRequest.setFindDuplicates("HereWeHaveSomeDuplicatedCharacters");
		jRequest.setId(10090);
		jRequest.setValidateMeOnlyIActuallyShouldBeABoolean(false);
		jRequest.setWhiteSpacesGalore("Can we replace all this white spaces without using replace please");
		jRequest.setNumbersMeetNumbers(new int[] { 35, 2, 100, 15, 75, 25, 99 });

		String inputJson = super.mapToJson(jRequest);
		mockMvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andExpect(status().isOk()).andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.findDuplicates").value("HereWeHaveSomeDuplicatedCharacters"))
				.andExpect(jsonPath("$.whiteSpacesGalore")
						.value("Can we replace all this white spaces without using replace please"))
				.andExpect(jsonPath("$.validateMeOnlyIActuallyShouldBeABoolean").value("false"))
				.andExpect(jsonPath("$.numbersMeetNumbers").isArray())
				.andExpect(jsonPath("$.numbersMeetNumbers", hasSize(7)))
				.andExpect(jsonPath("$.numbersMeetNumbers", containsInAnyOrder(35, 2, 100, 15, 75, 25, 99)));
	}

}
