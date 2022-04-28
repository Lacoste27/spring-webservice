package com.aceky.reportit.service.report;

import java.util.List;

import com.aceky.reportit.data.models.Report;
import com.aceky.reportit.data.payloads.request.ReportRequest;
import com.aceky.reportit.data.payloads.request.ReportUpdateRequest;
import com.aceky.reportit.data.payloads.response.MessageResponse;

import org.springframework.stereotype.Component;

@Component
public interface ReportService {

  Report createReports(ReportRequest reportsRequest, Integer userId);

  Report updateReport(ReportUpdateRequest reportUpdateRequest, Integer setter_id);

  List<Report> getAllReports();

  List<Report> getReports(Integer idUser);

  List<Report> getListReports(Integer idUser);

  void deleteReports(Integer reportsId);

  List<Report> getReportByRegion(Integer region_id);
}
