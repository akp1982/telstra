package com.telstra.bootapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.telstra.bootapi.dao.IJProcessServiceDao;
import com.telstra.bootapi.models.JRequest;
import com.telstra.bootapi.models.Outgoing;
import com.telstra.bootapi.util.Utils;

@Service
public class JRequestProcessingService implements IJRequestProcessingService{
	@Autowired
	IJProcessServiceDao serviceDao;
	
	@Autowired
	Utils util;
	
	@Override
	public JRequest processJReqSave(JRequest jReq) {
		
		
		boolean validOperation = false;
		int retry=0;
		do {
			try {				
				jReq.set_id(util.assignJReqID());
				//jrep.save(jreq);
				serviceDao.saveJRequest(jReq);
				validOperation=true;
			} catch (DuplicateKeyException de) {
				retry++;
				System.out.println("Incorrect Id");
				System.out.println("Try-"+retry);
			}

		} while (!validOperation);
		
		//compute largest number in an array
		try {
			int largest= util.computeLargest(jReq);
			String dupChar = util.findDuplicate(jReq);
			String remWhtSpace = util.removeWhtSpace(jReq);
			
			Outgoing obj = new Outgoing();
			obj.set_id(util.assignJReqID());
			obj.setDupInString(dupChar);
			obj.setLargestInArray(largest);
			obj.setRemoveWhtSpaceString(remWhtSpace);
			
			serviceDao.saveOutgoing(obj);
			
		}catch(Exception ie) {
			ie.printStackTrace();
		}
		

		System.out.println("*** createJReq END ***");
		return jReq;
	}
	

}
