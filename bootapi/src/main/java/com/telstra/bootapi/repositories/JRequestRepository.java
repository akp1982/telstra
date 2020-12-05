package com.telstra.bootapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.telstra.bootapi.models.JRequest;

public interface JRequestRepository extends MongoRepository<JRequest, Integer> {
  JRequest findBy_id(Integer id);
}
