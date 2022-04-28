package com.aceky.reportit.data.models;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.aceky.reportit.data.payloads.request.ReportRequest;
import com.aceky.reportit.data.payloads.request.ReportUpdateRequest;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.hibernate.annotations.ColumnDefault;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "reports")
public class Report {
    @Id
    @GeneratedValue(generator = "increment")
    Integer id;
    // @JsonBackReference
    // @ManyToOne(fetch = FetchType.LAZY)
    @OneToOne
    @JoinColumn(name = "user_id")
    User user;
    float latitude;
    float longitude;
    // @JsonBackReference
    // @ManyToOne(fetch = FetchType.LAZY)
    @OneToOne
    @JoinColumn(name = "type_id")
    ReportType type;
    // @JsonBackReference
    // @ManyToOne(fetch = FetchType.LAZY)
    @OneToOne
    @JoinColumn(name = "region_id")
    @ColumnDefault("null")
    Region region;
    String created_at;
    // @Column(columnDefinition = "datetime")
    // String created_at;
    String description;
    Integer level;
    Integer state;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, mappedBy = "report")
    private Set<ReportImage> images;

    public static Report from(ReportRequest reportsRequest) {
        Report report = new Report();
        report.setLatitude(reportsRequest.getLatitude());
        report.setLongitude(reportsRequest.getLatitude());
        report.setRegion(null);
        report.setCreated_at(reportsRequest.getCreated_at());
        report.setDescription(reportsRequest.getDescription());
        report.setLevel(reportsRequest.getLevel());
        report.setState(0);
        return report;
    }

    public static Report update(ReportUpdateRequest reportUpdateRequest) {
        Report report = new Report();
        report.setDescription(reportUpdateRequest.getDescription());
        report.setId(reportUpdateRequest.getId());
        report.setImages(new HashSet<ReportImage>(Arrays.asList(reportUpdateRequest.getImages())));
        report.setLatitude(reportUpdateRequest.getLatitude());
        report.setLevel(reportUpdateRequest.getLevel());
        report.setLongitude(reportUpdateRequest.getLongitude());
        report.setRegion(reportUpdateRequest.getRegion());
        report.setState(reportUpdateRequest.getState());
        report.setType(reportUpdateRequest.getType());
        report.setUser(reportUpdateRequest.getUser());
        return report;
    }
}
