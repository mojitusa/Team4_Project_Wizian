package com.Team4.web.mongodbrepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.Team4.web.mongodbclass.Student;
import com.Team4.web.mongodbclass.Users;

public interface StudentRepo extends MongoRepository<Student, String>{

	Student findByUsers(Users users);
	
}
