package com.example.myboard.controller;

import com.example.myboard.domain.TbBoard;
import com.example.myboard.dto.PageDTO;
import com.example.myboard.dto.TbBoardDTO;
import com.example.myboard.dto.TbBoardUpdateFormDTO;
import com.example.myboard.dto.TbBoardWriteFormDTO;
import com.example.myboard.service.TbBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
public class TbBoardRestController {
    private final TbBoardService tbBoardService;
    //1. articles read
    //2. article create
    //3. article update
    //4. article delete
//    @GetMapping("/articles")
//    public ResponseEntity<List<TbBoardDTO>> getAllArticles() {
//        return ResponseEntity.status(HttpStatus.OK).body(tbBoardService.getAllArticles());
//    }
    @GetMapping("/articles")
    public ResponseEntity<PageDTO<TbBoardDTO>> getPagedArticles(@RequestParam(name = "currentPage",required = false) Integer currentPage) {
        if(currentPage == null ) currentPage = 1;
        return ResponseEntity.status(HttpStatus.OK).body(tbBoardService.getPagedArticles(currentPage));
    }
    @PostMapping("/articles")
    public ResponseEntity<TbBoardDTO> create(@RequestBody TbBoardWriteFormDTO dto) {
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
