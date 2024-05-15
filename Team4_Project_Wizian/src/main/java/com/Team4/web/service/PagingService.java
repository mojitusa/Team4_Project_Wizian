package com.Team4.web.service;

import java.util.List;

import com.Team4.web.util.Pagination;

public interface PagingService<T> {
    Pagination<T> paginate(List<T> content, int pageNumber, int pageSize);
}
