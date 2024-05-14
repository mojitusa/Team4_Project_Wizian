package com.Team4.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.Team4.web.mongodbclass.CslState;
import com.Team4.web.mongodbclass.Student;
import com.Team4.web.mongodbclass.Users;
import com.Team4.web.service.MongoDbService;

@Controller
public class MongoDbTestController {

	@Autowired
	MongoDbService mongoDbService;

	@Autowired
	Users users;
	
	@GetMapping("/list2")
	public String mdbList() {
//		List<TestClass> mdbClassList = ms.getMdbClassByName("zoo");
//		
//		for (TestClass mdbClass : mdbClassList) {
//			System.out.println(mdbClass.getName());
//			System.out.println(mdbClass.getAge());
//			System.out.println(mdbClass.getId());
//		}
		
//		users.setUser_no("1110000001");
//		users.setSe_cd("11");
//		users.setNo("10000001");
//		users.setPw("1234");
//		
//		ms.setUsersClass(users);
		
		
//		List<Users> usersList= ms.getUsersClass();
//		for (Users users : usersList) {
//			System.out.println(users.getUser_no());
//			System.out.println(users.getPw());
//		}
//
//		Users users = new Users();
//		users.setSe_cd("33");
//		users.setNo("20000002");
//		users.setUser_no("3320000002");
//				
//		Counselor counselor = new Counselor(users, null, "학생회관2", 1, 0, "2상담자가 직접 입력하는 부분입니다.2");
//		mongoDbService.setUsersClass(users);
//		mongoDbService.setCounselorClass(counselor);
		
//		Counselor counselor = mongoDbService.getCounselorByCslLoc("학생회관2");
//		System.out.println(counselor.getCsl_detail());
//		System.out.println(counselor.getUsers().getUser_no());
		
//		List<Counselor> counselorList = mongoDbService.getCounselor();
//		for (Counselor counselor : counselorList) {
//			System.out.println(counselor.getUsers().getId());
//			System.out.println(counselor.getUsers().getUser_no());
//			System.out.println(counselor.getUsers().getSe_cd());
//			System.out.println(counselor.getUsers().getNo());
//			System.out.println(counselor.getUsers().getPw());
//			System.out.println(counselor.getUsers().getClass());
//			System.out.println(counselor.getCsl_loc());
//			System.out.println(counselor.getNon_face());
//			System.out.println(counselor.getChat());
//			System.out.println(counselor.getCsl_detail());
//			System.out.println(counselor.getClass());
//		}
		
//		users = mongoDbService.getMdbClassByUserNo("1110000001");
//		Counselor counselor = new Counselor(users, null, "학생회관 4층", 1, 1, "싱담자가 입력하는 공간입니다.");
//		mongoDbService.setCounselorClass(counselor);
		
		//학생하고 학원 다대일 관계
		//학원 객체 생성
//		Academy academy = new Academy();
//		academy.setName("중앙정보처리학원");
//		academy.setLoc("신촌");
		//mongoDbService.setAcademy(academy);
		
		//학생 객체 생성
		//Student student = new Student("홍길동", 20, academy);
//		Academy academy = mongoDbService.getAcademyByName("중앙정보처리학원");
//		Student student = new Student("남규리", 0, academy);
//		mongoDbService.setStudent(student);
		
//		mongoDbService.setAcademy(academy);
//		mongoDbService.setStudent(student);
//		academy.setStudent(mongoDbService.getStudentByName("홍길동"));
		
//		List<Counselor> counselorList = mongoDbService.getAllCounselor(); 
//		for (Counselor counselor : counselorList) {
//			System.out.println(counselor.getCsl_detail());
//			System.out.println(counselor.getUsers().getId());
//			System.out.println(counselor.getUsers().getUser_no());
//		}
//		Counselor counselor = mongoDbService.getCounselorByUserNo("3320000002");
//		counselor.setName("김상담");
//		CslSch cslSch = new CslSch();
//		cslSch.setCounselor(counselor);
//		cslSch.setOpen_date(LocalDate.parse("2024-05-13"));
//		cslSch.setBook(false);
//		cslSch.setCsl_time("0900");
//		mongoDbService.setSclSch(cslSch);
//		mongoDbService.setCounselorClass(counselor);
		
		
		
		

		return "redirect:index";
	}
}
