package com.example.myboard.dto;

import com.example.myboard.domain.TbBoard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TbBoardWriteFormDTO {
    private String title;
    private String content;
}
