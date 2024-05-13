package com.Team4.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Team4.web.mongodbclass.Academy;
import com.Team4.web.mongodbclass.Counselor;
import com.Team4.web.mongodbclass.CslSch;
import com.Team4.web.mongodbclass.Student;
import com.Team4.web.mongodbclass.TestClass;
import com.Team4.web.mongodbclass.Users;
import com.Team4.web.mongodbrepository.AcademyRepo;
import com.Team4.web.mongodbrepository.CounselorCustomRepository;
import com.Team4.web.mongodbrepository.CounselorRepo;
import com.Team4.web.mongodbrepository.CslSchRepo;
import com.Team4.web.mongodbrepository.MongoDbRepo;
import com.Team4.web.mongodbrepository.StudentRepo;
import com.Team4.web.mongodbrepository.UsersRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MongoDbService {
    
	@Autowired
    MongoDbRepo mRepo;
	
	@Autowired
	UsersRepo usersRepo;
	
	@Autowired
	CounselorRepo counselorRepo;
	
	@Autowired
	StudentRepo studentRepo;
	
	@Autowired
	AcademyRepo academyRepo;
	
	@Autowired
	CounselorCustomRepository couselorCustomRepo;
	
	@Autowired
	CslSchRepo cslSchRepo;
	
    public List<TestClass> getMdbClassByName(String name) {
        return mRepo.findByName(name);
    }
    
    public void setUsersClass(Users users) {
    	 usersRepo.save(users);
    }
    
    public List<Users> getUsersClass() {
    	return usersRepo.findAll();
    }
    
	public void setCounselorClass(Counselor counselor) {
		counselorRepo.save(counselor);
	}

	public List<Counselor> getCounselor() {
		return counselorRepo.findAll();
		
	}

	public Users getMdbClassByUserNo(String userNo) {
		return usersRepo.findByUserNo("1110000001");
	}

	public void setStudent(Student student) {
		studentRepo.save(student);
	}

	public void setAcademy(Academy academy) {
		academyRepo.save(academy);
	}

	public Student getStudentByName(String string) {
		return studentRepo.findAllByName(string);
	}

	public Academy getAcademyByName(String name ) {
		return academyRepo.findByName(name);
	}

	public Counselor getCounselorByUserNo(String userNo) {
		Users users = usersRepo.findByUserNo(userNo);
		//System.out.println(users.getUser_no());
		//System.out.println(couselorCustomRepo.findByUsersUserNo(userNo).getCsl_detail());
		
		return counselorRepo.findByUsers(users);
	}

	public List<Counselor> getAllCounselor() {
		return counselorRepo.findAll();
	}

	public Counselor getCounselorByCslLoc(String cslLoc) {
		return counselorRepo.findByCslLoc(cslLoc);
	}

	public void setSclSch(CslSch cslSch) {
		cslSchRepo.save(cslSch);
	}
}