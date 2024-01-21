package com.example.myboard.util;

import com.example.myboard.domain.TbBoard;
import com.example.myboard.dto.TbBoardDTO;
import com.example.myboard.dto.TbBoardWriteFormDTO;

public class DtoMapper {
//    public static TbBoardDTO writeFormToDTO(TbBoardWriteFormDTO dto) {
//
//    }
    public static TbBoard writeFormToDomain(TbBoardWriteFormDTO dto) {
        return TbBoard.of(dto.getTitle(), dto.getContent());
    }
    public static TbBoard TbBoardDtoToTbBoard(TbBoardDTO dto) {
        return TbBoard.of(dto.getTitle(),dto.getContent());
    }
    public static TbBoardDTO TbBoardToTbBoardDTO(TbBoard tbBoard) {
        return TbBoardDTO.builder()
                .id(tbBoard.getId())
                .title(tbBoard.getTitle())
                .content(tbBoard.getContent())
                .createAt(tbBoard.getCreateAt())
                .modifiedAt(tbBoard.getModifiedAt())
                .views(tbBoard.getViews())
                .build();
    }
}
