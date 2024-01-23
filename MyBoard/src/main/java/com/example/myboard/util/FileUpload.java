package com.example.myboard.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUpload {

    public static boolean storeFile(MultipartFile multipartFile) throws IOException
    {
        if (multipartFile.isEmpty()) {
            return false;
        }
        String filename = multipartFile.getOriginalFilename();
        multipartFile.transferTo(new File(getFullPath(filename)));
        return true;
    }
    public static String getFullPath(String fileName) {
        return "/Users/musung/testStore/" + fileName;
    }
}
