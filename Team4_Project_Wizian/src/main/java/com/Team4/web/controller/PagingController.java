package com.Team4.web.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Team4.web.entity.Inquiry;
import com.Team4.web.service.PagingService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PagingController {
 
    private final PagingService pagingService;
 
    @GetMapping("/posts/paging")
    public String paging(@PageableDefault(page = 0) Pageable pageable, Model model) {
        Page<Inquiry> postsPages = pagingService.paging(pageable);
 
        int blockLimit = 3;
        int startPage = Math.max(0, ((pageable.getPageNumber() / blockLimit) - 1) * blockLimit + 1);
        int endPage = Math.min((startPage + blockLimit - 1), postsPages.getTotalPages());
 
        model.addAttribute("postsPages", postsPages);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        return "inquiryhistory"; // 변경된 템플릿 파일명으로 수정해야 합니다.
    }
}
