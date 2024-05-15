package com.Team4.web.service;

import com.Team4.web.util.Pagination;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagingServiceImpl<T> implements PagingService<T> {
    @Override
    public Pagination<T> paginate(List<T> content, int pageNumber, int pageSize) {
        int fromIndex = (pageNumber - 1) * pageSize;
        int toIndex = Math.min(fromIndex + pageSize, content.size());

        List<T> currentPageContent = content.subList(fromIndex, toIndex);
        int totalPages = (int) Math.ceil((double) content.size() / pageSize);

        return new Pagination<>(currentPageContent, pageNumber, totalPages);
    }
}
