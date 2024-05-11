package com.Team4.web.service;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.Team4.web.mdbclass.MdbClass;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MongoDbService {
	private final MongoRepository mRepo;
	
	public MdbClass getMdbClassyByName(String name) {
		MdbClass crawlingInfo = mRepo.findMdbClassByName(name);
	}

}
