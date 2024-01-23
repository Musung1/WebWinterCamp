package com.example.myboard.dto;

import com.example.myboard.domain.TbBoard;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Schema
public class TbBoardUpdateFormDTO {
    @Schema(description = "아이디", example="asdfjkleidkdkdkslw")
    private String id;
    @Schema(description = "제목", example="제목입니다")
    private String title;
    @Schema(description = "내용", example="내용입니다")
    private String content;

}
