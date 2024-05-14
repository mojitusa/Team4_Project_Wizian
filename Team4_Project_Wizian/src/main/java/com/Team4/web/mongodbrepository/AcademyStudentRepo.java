package com.Team4.web.mongodbrepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Team4.web.mongodbclass.AcademyStudent;

public interface AcademyStudentRepo extends MongoRepository<AcademyStudent, String> {

	AcademyStudent findAllByName(String string);

}
