package com.aceky.reportit.web;

import java.util.List;

import com.aceky.reportit.data.models.ReportImage;

import com.aceky.reportit.service.reportimages.ReportsImagesServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/reportsimages")
public class ReportsImageController {
    @Autowired
    private ReportsImagesServiceImpl imagesService;

    @GetMapping("/all")
    public ResponseEntity<List<ReportImage>> getAll() {
        return new ResponseEntity<>(this.imagesService.findAll(), HttpStatus.OK);
    }

}
