package com.example.myboard.service;

import com.example.myboard.domain.TbBoard;
import com.example.myboard.dto.PageDTO;
import com.example.myboard.dto.TbBoardDTO;
import com.example.myboard.dto.TbBoardUpdateFormDTO;
import com.example.myboard.dto.TbBoardWriteFormDTO;
import com.example.myboard.mapper.TbBoardMapper;
import com.example.myboard.repository.TbBoardRepository;
import com.example.myboard.util.DtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class TbBoardServiceImpl implements TbBoardService{
    private final TbBoardRepository tbBoardRepository;
    private final TbBoardMapper tbBoardMapper;
    @Override
    public TbBoardDTO save(TbBoardWriteFormDTO dto) {
        TbBoard tbBoard = tbBoardRepository.save(DtoMapper.writeFormToDomain(dto));
        return DtoMapper.TbBoardToTbBoardDTO(tbBoard);
    }

    @Override
    public List<TbBoardDTO> getAllArticles() {
        List<TbBoard> tbList = tbBoardRepository.findAll();
        return tbList.stream()
                .filter((tbBoard -> !tbBoard.getDeleted().equals("Y")))
                .map((tbBoard -> DtoMapper.TbBoardToTbBoardDTO(tbBoard)))
                .toList();
    }

    @Override
    public PageDTO<TbBoardDTO> getPagedArticles(int currentPage) {
        //1. 전체 게시글 수 구함
        int totalElement = tbBoardMapper.countAll();
        //2. 페이지 사이즈 정함 (default = 10)
        int pageSize = 10;
        //3. 페이지 수 구함
        int totalPage = (totalElement/pageSize) + 1;
        //4. index 대로 pageSize만큼 query로 게시글 가져옴
        Map<String,Integer> pageInfo = new HashMap<>();
        pageInfo.put("pageSize",pageSize);
        pageInfo.put("offset",pageSize*(currentPage-1));
        List<TbBoardDTO> pagedElements = tbBoardMapper.getPagedElements(pageInfo);
        //PageDTO로 리턴
        PageDTO<TbBoardDTO> result = new PageDTO<>();
        result.setCurrentPage(currentPage);
        result.setPageSize(pageSize);
        result.setTotalPage(totalPage);
        result.setElements(pagedElements);
        return result;
    }

    @Override
    public TbBoardDTO update(TbBoardUpdateFormDTO dto) {
        TbBoard tbBoard = tbBoardRepository.findById(dto.getId()).orElseThrow();
        tbBoard.setTitle(dto.getTitle());
        tbBoard.setContent(dto.getContent());
        tbBoardRepository.save(tbBoard);
        return DtoMapper.TbBoardToTbBoardDTO(tbBoard);
    }

    @Override
    public TbBoardDTO delete(String id) {
        TbBoard tbBoard = tbBoardRepository.findById(id).orElseThrow();
        tbBoard.setDeleted("Y");
        tbBoardRepository.save(tbBoard);
        return DtoMapper.TbBoardToTbBoardDTO(tbBoard);

    }
}
