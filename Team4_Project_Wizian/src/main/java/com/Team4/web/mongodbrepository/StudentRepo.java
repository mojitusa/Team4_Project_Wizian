package com.Team4.web.mongodbrepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Team4.web.mongodbclass.Student;

public interface StudentRepo extends MongoRepository<Student, String> {

	Student findAllByName(String string);

}
