package com.aceky.reportit.service.report;

import java.util.List;
import java.util.Optional;

import com.aceky.reportit.data.models.Report;
import com.aceky.reportit.data.models.ReportImage;
import com.aceky.reportit.data.payloads.request.ImageRequest;
import com.aceky.reportit.data.payloads.request.ReportRequest;
import com.aceky.reportit.data.payloads.request.ReportUpdateRequest;
import com.aceky.reportit.data.payloads.response.MessageResponse;
import com.aceky.reportit.data.repositories.ReportRepository;
import com.aceky.reportit.data.repositories.ReportTypeRepository;
import com.aceky.reportit.data.repositories.ReportImageRepository;
import com.aceky.reportit.data.repositories.UserRepository;
import com.aceky.reportit.service.assignement.AssignementHistoryServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {
  @Autowired
  private ReportRepository reportRepository;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private ReportImageRepository reportImageRepository;
  @Autowired
  private ReportTypeRepository reportTypeRepository;

  @Autowired
  private AssignementHistoryServiceImpl assignementHistoryServiceImpl;

  @Override
  public Report createReports(ReportRequest reportRequest, Integer userId) {
    Report report = Report.from(reportRequest);
    report.setUser(userRepository.findById(userId).get());
    report.setType(reportRequest.getType());
    report = reportRepository.save(report);
    return report;
  }

  @Override
  public List<Report> getAllReports() {
    return reportRepository.findAll();
  }

  @Override
  public List<Report> getReports(Integer idUser) {
    return this.reportRepository.findByIdUser(idUser);
  }

  public List<Report> newReport() {
    return reportRepository.newReport();
  }

  public List<Report> assignedReport() {
    return reportRepository.assignedReport();
  }

  public List<Report> inProcessReport() {
    return reportRepository.inProcess();
  }

  public List<Report> solvedReport() {
    return reportRepository.solved();
  }

  public Optional<Report> findById(Integer report_id) {
    return this.reportRepository.findById(report_id);
  }

  @Override
  public Report updateReport(ReportUpdateRequest reportUpdateRequest, Integer setter_id) {
    Report report = Report.update(reportUpdateRequest);
    report = reportRepository.save(report);
    assignementHistoryServiceImpl.add(report, setter_id);
    return report;
  }

  @Override
  public List<Report> getListReports(Integer idUser) {
    return null;
  }

  @Override
  public void deleteReports(Integer reportsId) {
  }

  @Override
  public List<Report> getReportByRegion(Integer region_id) {
    List<Report> reports = reportRepository.findByIdRegion(region_id);
    return reports;
  }

}
