package com.example.myboard.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TbBoardWriteFormDTO {
    @NotNull(message = "공백은 입력할 수 없습니다")
    @Size(min = 3, max = 15)
    private String title;
    @NotNull(message = "공백은 입력할 수 없습니다")
    @Size(min = 5, max = 500)
    private String content;
}
