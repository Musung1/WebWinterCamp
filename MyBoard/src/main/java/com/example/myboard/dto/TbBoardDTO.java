package com.example.myboard.dto;

import com.example.myboard.domain.TbBoard;
import lombok.*;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class TbBoardDTO {
    private String id;
    private String title;
    private String content;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;
    private int views;
}
