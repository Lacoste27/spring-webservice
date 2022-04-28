package com.aceky.reportit.data.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.aceky.reportit.data.payloads.request.ImageRequest;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "reportImages")
public class ReportImage {
    @Id
    @GeneratedValue(generator = "increment")
    private Integer id;
    private String name;
    private String url;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "report_id")
    private Report report;

    public static ReportImage from(ImageRequest imageRequest) {
        ReportImage reportImage = new ReportImage();
        reportImage.setName(imageRequest.getName());
        reportImage.setUrl(imageRequest.getUrl());
        return reportImage;
    }

}