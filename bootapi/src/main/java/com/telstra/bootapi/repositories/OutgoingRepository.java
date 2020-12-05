package com.telstra.bootapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.telstra.bootapi.models.JRequest;
import com.telstra.bootapi.models.Outgoing;

public interface OutgoingRepository extends MongoRepository<Outgoing, Integer> {
	Outgoing findBy_id(Integer id);
}
