package com.example.myboard.controller;

import com.example.myboard.dto.page.PageDTO;
import com.example.myboard.dto.TbBoardDTO;
import com.example.myboard.dto.TbBoardUpdateFormDTO;
import com.example.myboard.dto.TbBoardWriteFormDTO;
import com.example.myboard.dto.page.PageOption;
import com.example.myboard.dto.page.PageSortType;
import com.example.myboard.service.TbBoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
@Tag(name = "BoardController", description = "BoardControllerAPI")
public class TbBoardRestController {
    private final TbBoardService tbBoardService;
    @Operation(summary = "게시판 글 조회" , description = "페이지 단위로 게시판 글을 조회합니다")
    @ApiResponse(responseCode = "200",description = "성공",
    content = {@Content(schema = @Schema(implementation = PageDTO.class))})
    @ApiResponse(responseCode = "404",description = "유효성 검사 실패")
    @GetMapping("/articles")
    public ResponseEntity<PageDTO<TbBoardDTO>> getPagedArticles(
            @RequestParam(name = "currentPage",required = false)
            @Schema(name = "currentPage", description = "현재 페이지", example = "1")
            Integer currentPage,
            @RequestParam(name = "keyword", required = false)
            @Schema(name = "keyword", description = "검색어", example = "하이")
            String keyword,
            @RequestParam(name = "order", required = false)
            @Schema(name = "order", description = "페이지 정렬 순서", example = "ASC")
            PageSortType order
            ) {
        if(currentPage == null ) currentPage = 1;
        PageOption pageOption = new PageOption();
        if(keyword != null) pageOption.setKeyword(keyword);
        pageOption.setCreatedSortType(order);
        return ResponseEntity.status(HttpStatus.OK).body(tbBoardService.getPagedArticles(currentPage,pageOption));
    }
    @PostMapping("/articles")
    public ResponseEntity<TbBoardDTO> create(@Valid @RequestBody  TbBoardWriteFormDTO dto) {
        TbBoardDTO tbBoardDTO = tbBoardService.save(dto);
        return ResponseEntity.status(HttpStatus.OK).body(tbBoardDTO);
    }
    @PutMapping("/articles")
    public ResponseEntity<TbBoardDTO> update(@RequestBody TbBoardUpdateFormDTO dto) {
        TbBoardDTO tbBoardDTO = tbBoardService.update(dto);
        return ResponseEntity.status(HttpStatus.OK).body(tbBoardDTO);
    }
    @DeleteMapping("/articles/{articleId}")
    public ResponseEntity<TbBoardDTO> delete(@PathVariable(name = "articleId") String articleId) {
        System.out.println(articleId);
        TbBoardDTO tbBoardDTO = tbBoardService.delete(articleId);
        return ResponseEntity.status(HttpStatus.OK).body(tbBoardDTO);
    }
}
