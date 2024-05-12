package com.Team4.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.Team4.web.mongodbclass.TestClass;
import com.Team4.web.service.MongoDbService;

@Controller
public class MongoDbTestController {

	@Autowired
	MongoDbService ms;
	
	@GetMapping("/list2")
	public String mdbList() {
		List<TestClass> mdbClassList = ms.getMdbClassByName("zoo");
		
		for (TestClass mdbClass : mdbClassList) {
			System.out.println(mdbClass.getName());
			System.out.println(mdbClass.getAge());
		}
		
		return "redirect:index";
	}
}
