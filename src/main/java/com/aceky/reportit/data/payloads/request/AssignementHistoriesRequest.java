package com.aceky.reportit.data.payloads.request;

import java.time.LocalDateTime;

import javax.persistence.Column;
import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
public class AssignementHistoriesRequest {
    Integer report_id ;
    Integer admin_id ;
    @Column(name = "date", columnDefinition = "DATETIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    LocalDateTime date;
    Integer setted_to;
    
}
