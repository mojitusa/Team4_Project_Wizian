package com.Team4.web.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Team4.web.mdbclass.MdbClass;

public interface MongoDbRepo extends MongoRepository<MdbClass, String>{
	MdbClass findMdbClassByName(String name);
}
