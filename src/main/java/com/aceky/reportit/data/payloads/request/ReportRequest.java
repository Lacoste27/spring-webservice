package com.aceky.reportit.data.payloads.request;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;

import com.aceky.reportit.data.models.ReportType;
import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
public class ReportRequest {
  int id;
  float latitude;
  float longitude;
  ReportType type;
  String created_at;
  String description;
  Integer level;
  Integer state;
  // ImageRequest[] images;
}
