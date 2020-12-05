package com.telstra.bootapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.telstra.bootapi.models.JRequest;

public class BootapiControllerTest extends AbstractTest{
	@Autowired
	Utils testUtils;
	
	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void createJRequest() throws Exception {
		System.out.println("Running createJRequest Test*******");
		String uri = "/jreq/";
		JRequest jRequest = new JRequest();
		jRequest.set_id(testUtils.assignJReqID());
		jRequest.setFindDuplicates("testing duplicates for jrequest");
		jRequest.setId(10090);
		jRequest.setValidateMeOnlyIActuallyShouldBeABoolean("false");
		jRequest.setWhiteSpacesGalore("remove white spaces string");
		jRequest.setNumbersMeetNumbers(new int[] {1,2,3,4,6});

		String inputJson = super.mapToJson(jRequest);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		//assertEquals(content, inputJson);
	}

}
