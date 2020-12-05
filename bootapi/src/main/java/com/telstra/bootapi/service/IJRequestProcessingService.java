package com.telstra.bootapi.service;

import com.telstra.bootapi.models.JRequest;
import com.telstra.bootapi.models.Outgoing;

public interface IJRequestProcessingService {
	JRequest processJReqSave(JRequest jReq) ;
	
}
