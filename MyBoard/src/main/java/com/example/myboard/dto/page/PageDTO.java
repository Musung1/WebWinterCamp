package com.example.myboard.dto.page;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageDTO<T> {
    private int totalPage;
    private int currentPage;
    private int pageSize;
    private PageOption option;
    private List<T> elements;
}

