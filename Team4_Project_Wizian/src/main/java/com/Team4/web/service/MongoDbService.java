package com.Team4.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.Team4.web.mongodbclass.TestClass;
import com.Team4.web.repository.MongoDbRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MongoDbService {
    
	@Autowired
    MongoDbRepo mRepo;
    
    public List<TestClass> getMdbClassByName(String name) {
        return mRepo.findByName(name);
    }

}