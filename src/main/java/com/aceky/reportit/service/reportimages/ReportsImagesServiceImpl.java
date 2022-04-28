package com.aceky.reportit.service.reportimages;

import java.util.List;

import com.aceky.reportit.data.models.ReportImage;
import com.aceky.reportit.data.repositories.ReportImageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportsImagesServiceImpl implements ReportsImagesService {

    @Autowired
    private ReportImageRepository imagesRepository;

    @Override
    public List<ReportImage> findAll() {
        return this.imagesRepository.findAll();
    }

    @Override
    public void save(ReportImage reportImage) {
        imagesRepository.save(reportImage);
    }
}
