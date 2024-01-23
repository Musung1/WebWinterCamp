package com.example.myboard.controller;
import com.example.myboard.dto.TbBoardDTO;
import com.example.myboard.dto.TbBoardWriteFormDTO;
import com.example.myboard.util.FileUpload;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FileUploadTestController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @PostMapping("/upload")
    @CrossOrigin
    public ResponseEntity<String> upload(@RequestParam(value = "image") MultipartFile file) throws IOException {
        logger.info(file.getName());
        logger.info(file.getOriginalFilename());
        logger.info(file.getContentType());
        logger.info(String.valueOf(file.getSize()));
        FileUpload.storeFile(file);
        return ResponseEntity.ok(file.getOriginalFilename());
    }
}
