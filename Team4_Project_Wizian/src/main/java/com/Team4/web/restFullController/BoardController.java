package com.Team4.web.restFullController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.Team4.web.entity.Inquiry;
import com.Team4.web.model.BoardModel;
import com.Team4.web.service.BoardService;
import com.Team4.web.service.InquiryService;
import com.Team4.web.util.Util;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpSession;

@RestController
public class BoardController {

	@Autowired
	private BoardService boardService;

	@Autowired
	private InquiryService inquiryService;
	@Autowired Util util;
	
	@GetMapping("/inquiryhistory")
	@ResponseBody
	public String inquiryHistory(HttpSession httpSession) {
	    Object session = util.getSession().getAttribute("userNo");
	    System.out.println(session);
	    List<BoardModel> boardList = boardService.boardList(session);

	    ObjectMapper objectMapper = new ObjectMapper();
	    String jsonBoardList = "";
	    try {
	        jsonBoardList = objectMapper.writeValueAsString(boardList);
	    } catch (JsonProcessingException e) {
	        e.printStackTrace();
	    }

	    System.out.println("보컨확인" + jsonBoardList);
	    return jsonBoardList;
	}
	
	@GetMapping("/counselHistory")
	public String counselHistoryPage(HttpSession session, @RequestParam(value = "category", required = false) String category,
            @RequestParam(value = "userNo", required = false) String userNo) throws JsonProcessingException {
		 List<Map<String, Object>> counselHistory;
	        System.out.println(category);
	        System.out.println(userNo);
	        if (category != null && !category.isEmpty() && userNo != null && !userNo.isEmpty()) {
	            counselHistory = inquiryService.getCounselBoard(category, userNo);
	        } else {
	            counselHistory = inquiryService.getCounselBoard("", userNo); 
	        }
		    ObjectMapper objectMapper = new ObjectMapper();
		    String counselHistory2 = "";
	        System.out.println("json동작확인" + counselHistory);
	        Map<String, Object> response = new HashMap<>();
	        response.put("counselHistory", counselHistory);
	        
	        counselHistory2 = objectMapper.writeValueAsString(counselHistory);
	        return counselHistory2;
	}
	
	@GetMapping("/counselHistory/json")
    @ResponseBody
    public Map<String, Object> counselHistoryJson(@RequestParam(value = "category", required = false) String category,
                                                  @RequestParam(value = "userNo", required = false) String userNo) {
        List<Map<String, Object>> counselHistory;
        System.out.println(category);
        System.out.println(userNo);
        if (category != null && !category.isEmpty() && userNo != null && !userNo.isEmpty()) {
            counselHistory = inquiryService.getCounselBoard(category, userNo);
        } else {
            counselHistory = inquiryService.getCounselBoard("", userNo);  // 전체 데이터 가져오기
        }
        System.out.println("json동작확인" + counselHistory);
        Map<String, Object> response = new HashMap<>();
        response.put("counselHistory", counselHistory);
        return response;
    }
	
	    @PostMapping("/selectDetail")
	    public Map<String, Object> getCounselDetail(@RequestBody Map<String, Object> request) {
	        int cslNo = (int) request.get("cslNo");
	        Object session = util.getSession().getAttribute("userNo");
	        String category = (String) request.get("selectedOption");
	       // System.out.println("selectDetail동작확인글번호" + cslNo);
	       // System.out.println("selectDetail동작확인카테고리" + category);
	        //System.out.println("selectDetail동작확인카테고리" + session);
	        
	        List<Map<String, Object>> counselDetail = boardService.getCounselDetail(cslNo, category, session);
	        Map<String, Object> response = new HashMap<>();
	        response.put("counselDetail", counselDetail);
	        System.out.println(counselDetail);
	        return response ;
	    }
	    
	    @PostMapping("/selectDetail2")
	    public Map<String, Object> getCounselDetail2(@RequestBody Map<String, Object> request) {
	        int cslNo = (int) request.get("cslNo");
	        Object session = util.getSession().getAttribute("userNo");
	        String category = (String) request.get("selectedOption");
	       // System.out.println("selectDetail2동작확인글번호" + cslNo);
	       // System.out.println("selectDetail2동작확인카테고리" + category);
	       // System.out.println("selectDetail2동작확인카테고리" + session);
	        
	        List<Map<String, Object>> counselDetail = boardService.getCounselDetail(cslNo, category, session);
	        Map<String, Object> response = new HashMap<>();
	        response.put("counselDetail", counselDetail);
	        System.out.println(counselDetail);
	        return response ;
	    }
	    
	    @PostMapping("/cancelReservation")
	    public ResponseEntity<Map<String, Object>> cancelReservation(@RequestBody Map<String, String> request) {
	        String cslNo = request.get("cslNo");
	        String cslCate = request.get("cslCate");
	        Object session = util.getSession().getAttribute("userNo");
	        //System.out.println("예약취소확인"+cslNo);
	        //System.out.println("예약취소확인"+cslCate);
	        int isCanceled = boardService.cancelReservation(cslNo, cslCate,session);
	        //System.out.println("예약취소확인"+isCanceled);
	        Map<String, Object> response = new HashMap<>();
	        if (isCanceled == 1) {
	            response.put("message", "예약이 성공적으로 취소되었습니다.");
	            return ResponseEntity.ok(response);
	        } else {
	            response.put("message", "예약 취소 중 오류가 발생했습니다.");
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	        }
	    }
	
}
