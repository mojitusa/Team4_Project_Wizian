package com.Team4.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Team4.web.entity.Inquiry;
import com.Team4.web.service.InquiryService;
import com.Team4.web.service.PagingService;
import com.Team4.web.util.Pagination;
import com.Team4.web.util.Util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class InquiryController {

	private final InquiryService inquiryService;
	private final PagingService<Inquiry> pagingService;
	
    @Autowired
    public InquiryController(InquiryService inquiryService, PagingService<Inquiry> pagingService) {
        this.inquiryService = inquiryService;
        this.pagingService = pagingService;
    }

	@Autowired
	private Util util;
	@GetMapping("/inquiry")
	public ModelAndView InquiryPage(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("inquiry"); // inquiry.html 파일로 매핑
		// 다른 모델 데이터 추가 가능
		return modelAndView;
	}

	@PostMapping("/inquiry")
	public String submitInquiry(@ModelAttribute Inquiry inquiry, RedirectAttributes redirectAttributes) {
		try {
			inquiryService.saveInquiry(inquiry);
			redirectAttributes.addFlashAttribute("성공");
			return "redirect:/receptioncomplete";
		} catch (Exception e) {
			return "error";
		}
	}

	@GetMapping("/inquiryhistory")
	public ModelAndView InquiryHistory(HttpServletRequest request, Model model, HttpSession httpSession) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("inquiryhistory");
		
		List<Inquiry> inquiries = inquiryService.getAllInquiries();
		modelAndView.addObject("inquiries", inquiries);
		
		String studNo = (String) httpSession.getAttribute("userNo");
		int boardCount = inquiryService.getBoardCount(studNo);
		model.addAttribute("studNo", studNo);
		model.addAttribute("boardCount", boardCount);
		
		int pageNumber = 1;
        int pageSize = 10;
        Pagination<Inquiry> pagination = pagingService.paginate(inquiries, pageNumber, pageSize);
        
        int totalInquiries = inquiries.size();
        int totalPages = (int) Math.ceil((double) totalInquiries / pageSize);

        model.addAttribute("totalPages", totalPages);
        model.addAttribute("pagination", pagination);
		
		return modelAndView;
	}
	@GetMapping("/inquiryhistory2")
	public String getInquiryHistory(Model model, HttpSession httpSession) {
	    return "inquiryhistory";
	}

	@GetMapping("/inquiry/detail/{id}")
	public ModelAndView showInquiryDetail(@PathVariable("id") int id) {
		ModelAndView modelAndView = new ModelAndView();
		Inquiry inquiry = inquiryService.findById(id);
		if (inquiry != null) {
			modelAndView.addObject("inquiry", inquiry);
			modelAndView.setViewName("inquirydetail");
		} else {
			modelAndView.setViewName("error");
		}
		return modelAndView;
	}

}
