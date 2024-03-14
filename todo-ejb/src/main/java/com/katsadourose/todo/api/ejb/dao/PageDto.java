package com.katsadourose.todo.api.ejb.dao;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PageDto<T> {

    private final int page;
    private final int pageSize;
    private final long totalPages;
    private final List<T> items;
}
