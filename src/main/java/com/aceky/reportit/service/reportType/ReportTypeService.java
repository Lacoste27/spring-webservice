package com.aceky.reportit.service.reportType;

import java.util.List;

import com.aceky.reportit.data.models.ReportType;

import org.springframework.stereotype.Component;

@Component
public interface ReportTypeService {
    List<ReportType> findAll();
}
