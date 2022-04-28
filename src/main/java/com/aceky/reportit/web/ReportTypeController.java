package com.aceky.reportit.web;

import java.util.List;

import com.aceky.reportit.data.models.ReportType;
import com.aceky.reportit.service.reportType.ReportTypeServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/reportType")
public class ReportTypeController {
    @Autowired
    private ReportTypeServiceImpl reportTypeServiceImpl;

    @GetMapping("/all")
    public ResponseEntity<List<ReportType>> getAll() {
        return new ResponseEntity<>(reportTypeServiceImpl.findAll(), HttpStatus.OK);
    }
}
