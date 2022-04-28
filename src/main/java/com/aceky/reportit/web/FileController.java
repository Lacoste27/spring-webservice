package com.aceky.reportit.web;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.aceky.reportit.data.payloads.response.ResponseMessage;
import com.aceky.reportit.service.file.FileStorageService;
import com.aceky.reportit.service.file.FileStorageServiceImpl;

import org.apache.commons.io.FileUtils;
import org.apache.tomcat.jni.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

@RestController
@RequestMapping("/api/file")
@CrossOrigin("*")
public class FileController {
    @Autowired
    FileStorageServiceImpl fileStorageServiceImpl;

    @GetMapping("/load/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        System.out.println(filename);
        Resource file = fileStorageServiceImpl.load(filename);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
                // .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" +
                // file.getFilename() + "\"")
                .body(file);
    }
}