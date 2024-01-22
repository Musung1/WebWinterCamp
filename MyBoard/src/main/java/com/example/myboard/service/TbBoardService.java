package com.example.myboard.service;

import com.example.myboard.dto.page.PageDTO;
import com.example.myboard.dto.TbBoardDTO;
import com.example.myboard.dto.TbBoardUpdateFormDTO;
import com.example.myboard.dto.TbBoardWriteFormDTO;
import com.example.myboard.dto.page.PageOption;

import java.util.List;

public interface TbBoardService {
    public TbBoardDTO save(TbBoardWriteFormDTO dto);
    public List<TbBoardDTO> getAllArticles();
    public PageDTO<TbBoardDTO> getPagedArticles(int currentPage, PageOption pageOption);
    public TbBoardDTO update(TbBoardUpdateFormDTO dto);
    public TbBoardDTO delete(String id);
}
