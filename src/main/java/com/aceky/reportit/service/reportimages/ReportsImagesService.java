package com.aceky.reportit.service.reportimages;

import java.util.List;

import com.aceky.reportit.data.models.ReportImage;

import org.springframework.stereotype.Component;

@Component
public interface ReportsImagesService {
    List<ReportImage> findAll();

    public void save(ReportImage reportImage);
}
