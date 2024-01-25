package com.example.myboard.controller;
import com.example.myboard.dto.ImagesDto;
import com.example.myboard.util.FileUpload;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Tag(name = "멀티미디어 파일 업로드 API", description = "멀티미디어파일을 업로드 할 수 있습니다.")
public class FileUploadTestController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @PostMapping("/upload")
    @CrossOrigin
    public ResponseEntity<String> upload(
            @RequestParam(value = "image") MultipartFile file,
            @RequestParam(value = "text") String text
    ) throws IOException {
        logger.info(file.getName());
        logger.info(file.getOriginalFilename());
        logger.info(file.getContentType());
        logger.info(String.valueOf(file.getSize()));
        logger.info(text);
        FileUpload.storeFile(file);
        return ResponseEntity.ok(file.getOriginalFilename());
    }
    @PostMapping(value = "/uploadFiles")
    @CrossOrigin
    public ResponseEntity<String> uploadFiles(ImagesDto imagesDto, HttpServletRequest request) throws IOException, ServletException {
        request.getParts().stream().forEach((part -> logger.info(part.getName())));

        logger.info(imagesDto.getTitle());
        imagesDto.getFiles().forEach((file -> logger.info(file.getOriginalFilename())));
        return ResponseEntity.ok(imagesDto.getTitle());
    }
}
