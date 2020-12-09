package com.telstra.bootapi;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.telstra.bootapi.models.JRequest;

public class UtilsTest extends AbstractTest{
	@Autowired
	Utils testUtils;
	
	@Override
	@Before
	public void setUp() {
		super.setUp();
	}
	
	@Test
	public void testComputeLargestUtils() throws Exception{
		System.out.println("Running Utils tests-computeLargest...");
		JRequest jRequest = new JRequest();
		jRequest.set_id(testUtils.assignJReqID());
		jRequest.setFindDuplicates("HereWeHaveSomeDuplicatedCharacters");
		jRequest.setId(10090);
		jRequest.setValidateMeOnlyIActuallyShouldBeABoolean(false);
		jRequest.setWhiteSpacesGalore("Can we replace all this white spaces without using replace please");
		jRequest.setNumbersMeetNumbers(new int[] { 35, 2, 100, 15, 75, 25, 99 });
		
		assertTrue(testUtils.computeLargest(jRequest)==100);
		assertFalse("Incorrect Value", testUtils.computeLargest(jRequest)==99);
		
	}
	
	@Test
	public void testRemoveWhtSpaceUtils() throws Exception{
		System.out.println("Running Utils tests-removeWhtSpace...");
		JRequest jRequest = new JRequest();
		jRequest.set_id(testUtils.assignJReqID());
		jRequest.setFindDuplicates("HereWeHaveSomeDuplicatedCharacters");
		jRequest.setId(10090);
		jRequest.setValidateMeOnlyIActuallyShouldBeABoolean(false);
		jRequest.setWhiteSpacesGalore("Can we replace all this white spaces without using replace please");
		jRequest.setNumbersMeetNumbers(new int[] { 35, 2, 100, 15, 75, 25, 99 });
		
		assertTrue(testUtils.removeWhtSpace(jRequest).contains("Canwereplaceallthiswhitespaceswithoutusingreplaceplease"));
		assertFalse("Incorrect String",testUtils.removeWhtSpace(jRequest).contains(" Canwereplaceallthiswhitespaceswithoutusingreplaceplease"));
		
	}
}
