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
 
    // @PageableDefault(page = 1) : page는 기본으로 1페이지를 보여준다.
    @GetMapping("/posts/paging")
    public String paging(@PageableDefault(page = 0) Pageable pageable, Model model) {
        Page<Inquiry> postsPages = pagingService.paging(pageable);
 
        /**
         * blockLimit : page 개수 설정
         * 현재 사용자가 선택한 페이지 앞 뒤로 3페이지씩만 보여준다.
         * ex : 현재 사용자가 4페이지라면 2, 3, (4), 5, 6
         */
        int blockLimit = 3;
        int startPage = Math.max(0, ((pageable.getPageNumber() / blockLimit) - 1) * blockLimit + 1);
        int endPage = Math.min((startPage + blockLimit - 1), postsPages.getTotalPages());
 
        model.addAttribute("postsPages", postsPages);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        return "inquiryhistory"; // 변경된 템플릿 파일명으로 수정해야 합니다.
    }
}
