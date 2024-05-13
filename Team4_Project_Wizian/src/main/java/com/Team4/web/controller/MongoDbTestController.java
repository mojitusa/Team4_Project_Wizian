//package com.Team4.web.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import com.Team4.web.mongodbclass.Counselor;
//import com.Team4.web.mongodbclass.TestClass;
//import com.Team4.web.mongodbclass.Users;
//import com.Team4.web.service.MongoDbService;
//
//@Controller
//public class MongoDbTestController {
//
//	@Autowired
//	MongoDbService ms;
//
//	@Autowired
//	Users users;
//	
//	@GetMapping("/list2")
//	public String mdbList() {
////		List<TestClass> mdbClassList = ms.getMdbClassByName("zoo");
////		
////		for (TestClass mdbClass : mdbClassList) {
////			System.out.println(mdbClass.getName());
////			System.out.println(mdbClass.getAge());
////			System.out.println(mdbClass.getId());
////		}
//		
////		users.setUser_no("1110000001");
////		users.setSe_cd("11");
////		users.setNo("10000001");
////		users.setPw("1234");
////		
////		ms.setUsersClass(users);
//		
//		
////		List<Users> usersList= ms.getUsersClass();
////		for (Users users : usersList) {
////			System.out.println(users.getUser_no());
////			System.out.println(users.getPw());
////		}
////
////		Users users = new Users("심리상담사 1호", "1310000003", "13", "10000003", "1111", null, null);
////		Counselor counselor = new Counselor(users, null, "학생회관", 1, 0, "상담자가 직접 입력하는 부분입니다.");
////		ms.setCounselorClass(counselor);
//		
//		List<Counselor> counselorList = ms.getCounselor();
//		for (Counselor counselor : counselorList) {
//			System.out.println(counselor.getCsl_loc());
//			System.out.println(counselor.getUser().getUser_no());
//		}
//		
//		return "redirect:index";
//	}
//}
