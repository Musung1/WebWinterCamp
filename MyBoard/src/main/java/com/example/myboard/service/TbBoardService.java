package com.example.myboard.service;

import com.example.myboard.domain.TbBoard;
import com.example.myboard.dto.TbBoardDTO;
import com.example.myboard.dto.TbBoardUpdateFormDTO;
import com.example.myboard.dto.TbBoardWriteFormDTO;

import java.util.List;

public interface TbBoardService {
    public TbBoardDTO save(TbBoardWriteFormDTO dto);
    public List<TbBoardDTO> getAllArticles();
    public TbBoardDTO update(TbBoardUpdateFormDTO dto);
    public TbBoardDTO delete(String id);
}
