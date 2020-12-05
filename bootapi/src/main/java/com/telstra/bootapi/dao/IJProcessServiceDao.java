package com.telstra.bootapi.dao;

import com.telstra.bootapi.models.JRequest;
import com.telstra.bootapi.models.Outgoing;

public interface IJProcessServiceDao {
	JRequest saveJRequest(JRequest jReq);
	Outgoing saveOutgoing(Outgoing outgoing);
}
