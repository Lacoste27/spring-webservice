package com.aceky.reportit.data.payloads.request;

import java.time.LocalDateTime;
import javax.persistence.Column;

import com.aceky.reportit.data.models.Region;
import com.aceky.reportit.data.models.ReportImage;
import com.aceky.reportit.data.models.ReportType;
import com.aceky.reportit.data.models.User;

import lombok.Data;

@Data
public class ReportUpdateRequest {
    Integer id;
    float latitude;
    float longitude;
    ReportType type;
    Region region;
    String description;
    Integer level;
    Integer state;
    ReportImage[] images;
    User user;
}
