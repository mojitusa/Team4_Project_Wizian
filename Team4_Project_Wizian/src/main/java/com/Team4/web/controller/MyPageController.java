//package com.Team4.web.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import com.Team4.web.service.MyPageService;
//import com.Team4.web.service.PsyCslService;
//
//import jakarta.servlet.http.HttpSession;
//
//@Controller
//public class MyPageController {
//	
//	@Autowired
//	private PsyCslService psyCslService;
//	
//	@Autowired
//	private MyPageService myPageService;
//	
//	@GetMapping("/myPage")
//	public String showMyPage(HttpSession httpSession) {
//		if (httpSession.getAttribute("userNo") == null) {
//			return "/login";
//		}
//		return "content/myPage";
//	}
//	@GetMapping("/myPageProF")
//	public String showMyPageProf(HttpSession httpSession) {
//		if (httpSession.getAttribute("userNo") == null) {
//			return "/login";
//		}
//		return "profcusl/myPageProF";
//	}
//	@GetMapping("/myPageCounS")
//	public String showMyPageCounS(HttpSession httpSession) {
//		if (httpSession.getAttribute("userNo") == null) {
//			return "/login";
//		}
//		return "content/myPageCounS";
//	}
//	
//	@GetMapping("/updatePrivacy")
//	public String showMyPagePri(HttpSession httpSession, Model model) {
//		if (httpSession.getAttribute("userNo") == null) {
//			return "/login";
//		}
//		model.addAttribute("student", psyCslService.getStudentByUserNo("1100000001"));
//		return "content/updatePrivacy";
//	}
//	
////	@PostMapping("/updatePrivacy")
////	public String updatePrivacy(@RequestParam("phoneNumber") String phoneNumber, 
////			@RequestParam("email") String email, 
////			@RequestParam("stud_no") String stud_no,
////			RedirectAttributes redirectAttributes) {
////		
////		return "redirect:/updatePrivacy";
////	}
//	@PostMapping("/updatePrivacy")
//	public ResponseEntity<String> updatePrivacy(@RequestParam("stud_no") String studNo,
//	                                            @RequestParam("phoneNumber") String phoneNumber,
//	                                            @RequestParam("email") String email) {
//	    System.out.println("업데이트 동작 확인");
//	    int updated = myPageService.updatePrivacy(phoneNumber, email, studNo);
//	    System.out.println(updated);
//	    String message;
//	    if (updated >= 1) {
//	        message = "개인 정보가 성공적으로 업데이트되었습니다.";
//	        System.out.println("업데이트 동작 확인1");
//	    } else {
//	        message = "프라이버시 정보 업데이트에 실패했습니다.";
//	        System.out.println("업데이트 동작 확인2");
//	    }
//	    return ResponseEntity.ok(message);
//	}
//}
