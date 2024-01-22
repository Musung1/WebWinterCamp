package com.example.myboard.mapper;

import com.example.myboard.dto.TbBoardDTO;

import java.util.List;
import java.util.Map;

public interface TbBoardMapper {
	int countAll();
	List<TbBoardDTO> getPagedElements(Map<String,Object> pageInfo);
}