package com.Team4.web.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Team4.web.service.GroupService;

import jakarta.servlet.http.HttpSession;

@Controller
public class GroupController {

	@Autowired
	private GroupService groupService;
	
	@GetMapping("/group")
	public String showGroupPage(@RequestParam(value = "searchText", required = false, defaultValue = "") String searchWord, Model model) {
		
		System.out.println("검색어 입력 테스트 : " + searchWord);
		
		if(searchWord == null || searchWord == "") {
			List<Map<String, Object>> gclist = groupService.gclist();
			model.addAttribute("gclist", gclist);
		} else {
			List<Map<String, Object>> gclist = groupService.getgcListWithSearch(searchWord);
			model.addAttribute("gclist", gclist);
			
			System.out.println(gclist);
		}
		
		return "content/group";
	}

	@GetMapping("/groupDetail")
	public String showGroupDetailPage(@RequestParam(value = "no", required = false, defaultValue = "") int procd,
			Model model) {

		List<Map<String, Object>> proDetail = groupService.proDetail(procd);
		model.addAttribute("proDetail", proDetail);

		return "content/groupDetail";
	}
	
	@GetMapping("/groupApplyPage")
	public String showGroupapplyPage(@RequestParam(value = "no", required = false, defaultValue = "") int procd, Model model, HttpSession session) {
		
		String studNumber = (String) session.getAttribute("userNo");
		String studName = (String) session.getAttribute("username");
		
		if(studNumber != null && studName != null) {
			List<Map<String, Object>> proDetail = groupService.proDetail(procd);
			model.addAttribute("proDetail", proDetail);
			
			return "content/groupApplyPage";
		} else {
			return "/login";
		}
	}
	
	//그룹 상담 신청 메소드
	@PostMapping("/groupApplyPage")
	@ResponseBody
	public String groupapplyProgram(@RequestParam(name = "proCd", required = false, defaultValue = "") String proCode, HttpSession session) {
		
		String studNumber = (String) session.getAttribute("userNo");
		String studName = (String) session.getAttribute("username");
        
		if(studNumber != null && studName != null) {
			
			// 중복 검사 체크
			if(groupService.checkDuplicate(studNumber, proCode)) {
				System.out.println("중복검사가 정상적으로 작동되었습니다.");
				return "already_applied";
			}
			
	        // 프로그램 기한 확인
	        Map<String, Object> programDates = groupService.getProgramDates(proCode);
	        if (programDates != null) {
	            Date schdlBeginDate = (Date) programDates.get("SCHDL_BGNG_YMD");
	            Date schdlEndDate = (Date) programDates.get("SCHDL_END_YMD");

	            Timestamp schdlBegin = new Timestamp(schdlBeginDate.getTime());
	            Timestamp schdlEnd = new Timestamp(schdlEndDate.getTime());
	            Timestamp now = new Timestamp(System.currentTimeMillis());
	            
	            if (now.before(schdlBegin) || now.after(schdlEnd)) {
	                return "dateOver";
	            }
	        }
			// 프로그램 신청 TB에 저장
			int result = groupService.insertApply(studNumber, proCode);
			System.out.println("결과 확인 : " + result);
			
			return "success";
		} else {
			return "noLogin";
		}
	}
	
	@PostMapping("/groupapplyDelete")
	@ResponseBody
	public String groupapplyDelete(@RequestParam(name = "proCd", required = false, defaultValue = "") String proCode, HttpSession session) {
	    
	    String studNumber = (String) session.getAttribute("userNo");
	    String studName = (String) session.getAttribute("username");
	    
	    System.out.println("학번 : " + studNumber);
	    System.out.println("프로그램 코드 : " + proCode);
	    
	    if (studNumber != null && studName != null) {
	        
	        Map<String, Object> programCancelDate = groupService.getProgramCancelDate(proCode);
	        if (programCancelDate != null) {
	            Date gcDT = (Date) programCancelDate.get("GC_DT");
	            Timestamp gcDt = new Timestamp(gcDT.getTime());
	            Timestamp now = new Timestamp(System.currentTimeMillis());
	            
	            if (gcDt != null && now.after(gcDt)) {
	                return "dateOver";
	            }
	        }
	        
	        // 중복 검사 체크
	        if (!groupService.checkDuplicate(studNumber, proCode)) {
	            System.out.println("유효성 검사가 정상적으로 작동하였습니다.");
	            return "no_exist";
	        } else {
	            // 프로그램 삭제 TB에 저장
	            int result = groupService.deleteApply(studNumber, proCode);
	            System.out.println("결과 확인 : " + result);
	            
	            // 성공 응답 반환
	            return "success";
	        }
	    } else {
	        return "noLogin";
	    }
	}
}