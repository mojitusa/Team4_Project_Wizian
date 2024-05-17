package com.Team4.web.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.Team4.web.entity.Inquiry;

@Service
public class PagingService {
    
    private final PagingRepository pagingRepository;

    public PagingService(PagingRepository pagingRepository) {
        this.pagingRepository = pagingRepository;
    }

    public Page<Inquiry> paging(Pageable pageable) {
        int page = pageable.getPageNumber(); // 페이지 번호는 0부터 시작하므로 -1을 제거합니다.
        int pageLimit = 3; // 한 페이지에 보여줄 글 개수

        // 한 페이지당 3개식 글을 보여주고 정렬 기준은 ID 기준으로 내림차순
        Page<Inquiry> postsPages = pagingRepository.findAll(PageRequest.of(page, pageLimit, Sort.by(Sort.Direction.DESC, "id")));

        return postsPages;
    }
}
