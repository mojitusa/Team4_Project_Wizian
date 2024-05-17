package com.Team4.web.restFullController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.Team4.web.entity.Inquiry;
import com.Team4.web.model.BoardModel;
import com.Team4.web.service.BoardService;
import com.Team4.web.service.InquiryService;

import jakarta.servlet.http.HttpSession;

@RestController
public class BoardController {

	@Autowired
	private BoardService boardService;

	@GetMapping("/inquiryhistory")
	@ResponseBody
	public List<BoardModel> inquiryHistory(HttpSession httpSession) {

		List<BoardModel> boardList = boardService.boardList();

		System.out.println(boardList);
		return boardList;
	}

}
