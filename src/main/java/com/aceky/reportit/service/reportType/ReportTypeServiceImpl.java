package com.aceky.reportit.service.reportType;

import java.util.List;

import com.aceky.reportit.data.models.ReportType;
import com.aceky.reportit.data.repositories.ReportTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportTypeServiceImpl implements ReportTypeService {
    @Autowired
    ReportTypeRepository reportTypeRepository;

    @Override
    public List<ReportType> findAll() {
        return reportTypeRepository.findAll();
    }
}
