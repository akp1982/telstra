package com.telstra.bootapi.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.telstra.bootapi.models.JRequest;
import com.telstra.bootapi.models.Outgoing;
import com.telstra.bootapi.repositories.JRequestRepository;
import com.telstra.bootapi.repositories.OutgoingRepository;

@Repository
public class JProcessServiceDao implements IJProcessServiceDao{
	@Autowired
	JRequestRepository repository;
	
	@Autowired
	OutgoingRepository outgoingRepository;

	@Override
	public JRequest saveJRequest(JRequest jReq) {
		// TODO Auto-generated method stub
		return repository.save(jReq);
	}

	@Override
	public Outgoing saveOutgoing(Outgoing outgoing) {
		// TODO Auto-generated method stub
		return outgoingRepository.save(outgoing);
	}

}
