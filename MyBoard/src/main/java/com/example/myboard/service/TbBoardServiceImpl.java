package com.example.myboard.service;

import com.example.myboard.domain.TbBoard;
import com.example.myboard.dto.TbBoardDTO;
import com.example.myboard.dto.TbBoardUpdateFormDTO;
import com.example.myboard.dto.TbBoardWriteFormDTO;
import com.example.myboard.repository.TbBoardRepository;
import com.example.myboard.util.DtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TbBoardServiceImpl implements TbBoardService{
    private final TbBoardRepository tbBoardRepository;
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
