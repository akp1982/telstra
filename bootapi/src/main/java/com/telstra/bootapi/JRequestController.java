package com.telstra.bootapi;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.telstra.bootapi.models.JRequest;
import com.telstra.bootapi.service.IJRequestProcessingService;

@RestController
@Validated
@RequestMapping("/jreq")
public class JRequestController {
	@Autowired
	IJRequestProcessingService processService;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public JRequest createJReq(@Valid @RequestBody JRequest jReq) {
		System.out.println("*** createJReq START ***");
		System.out.println("");
		processService.processJReqSave(jReq);
		// pets.set_id(ObjectId.get());
		// repository.save(pets);
		/*
		 * boolean validOperation = false; int retry=0; do { try {
		 * processService.processJReqSave(jReq); jreq.set_id(assignJReqID());
		 * jrep.save(jreq); validOperation=true; } catch (DuplicateKeyException de) {
		 * retry++; System.out.println("Incorrect Id");
		 * System.out.println("Try-"+retry); }
		 * 
		 * } while (!validOperation);
		 */

		System.out.println("*** createJReq END ***");
		return jReq;
	}

	

}
