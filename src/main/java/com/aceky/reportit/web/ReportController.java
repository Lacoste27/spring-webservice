package com.aceky.reportit.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.aceky.reportit.data.models.Report;
import com.aceky.reportit.data.models.ReportImage;
import com.aceky.reportit.data.payloads.request.ImageRequest;
import com.aceky.reportit.data.payloads.request.ReportRequest;
import com.aceky.reportit.data.payloads.request.ReportUpdateRequest;
import com.aceky.reportit.data.payloads.response.MessageResponse;
import com.aceky.reportit.data.repositories.ReportRepository;
import com.aceky.reportit.service.file.FileStorageServiceImpl;
import com.aceky.reportit.service.report.ReportServiceImpl;
import com.aceky.reportit.service.reportimages.ReportsImagesServiceImpl;
import com.fasterxml.jackson.module.kotlin.ReflectionCache.BooleanTriState.False;
import com.google.gson.Gson;
import com.sipios.springsearch.anotation.SearchSpec;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.util.StringUtils;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("api/report")
public class ReportController {
  @Autowired
  private ReportServiceImpl reportServiceImp;

  @Autowired
  ReportRepository reportRepository;

  @Autowired
  FileStorageServiceImpl fileStorageServiceImpl;

  @Autowired
  ReportsImagesServiceImpl reportsImagesServiceImpl;

  @PostMapping(path = "/add/user/{user_id}", headers = "Content-type=*/*")
  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
  public ResponseEntity<MessageResponse> addReports(
      @RequestParam(value = "files", required = false) String fileslist,
      @PathVariable(value = "user_id") Integer userId,
      @RequestParam(value = "data", required = true) String reports) {
    MessageResponse message = new MessageResponse("report added successfuly");

    Gson converter = new Gson();
    ReportRequest reportRequest = converter.fromJson(reports, ReportRequest.class);
    reportRequest.setState(1);

    final List<ReportImage> images = new ArrayList<ReportImage>();

    List<MultipartFile> files = fileStorageServiceImpl.converttomulitpart(fileslist);

    try {
      List<String> fileNames = new ArrayList<>();
      for (MultipartFile file : files) {
        String extension = StringUtils.getFilenameExtension(file.getOriginalFilename());
        String name = RandomStringUtils.randomAlphanumeric(16) + "." + extension;
        fileStorageServiceImpl.save(file, name);
        String url = "https://reportitws.herokuapp.com/api/file/load/" + name;
        images.add(ReportImage.from(new ImageRequest(name, url)));
        fileNames.add(name);
      }
      message.setMessage(message.getMessage() +
          " Uploaded the files successfully: files");
    } catch (Exception e) {
      message.setMessage(message.getMessage() + "Fail to upload files!");
    }
    Report report = reportServiceImp.createReports(reportRequest, userId);
    for (ReportImage reportImage : images) {
      reportImage.setReport(report);
      reportsImagesServiceImpl.save(reportImage);
    }

    return new ResponseEntity<>(message, HttpStatus.CREATED);
  }

  @GetMapping("/all")
  public ResponseEntity<List<Report>> getAllReports() {
    List<Report> reports = reportServiceImp.getAllReports();
    return new ResponseEntity<>(reports, HttpStatus.OK);
  }

  @GetMapping("/user/{id}")
  public ResponseEntity<List<Report>> getReports(@PathVariable Integer id) {
    List<Report> Reports = reportServiceImp.getReports(id);
    return new ResponseEntity<>(Reports, HttpStatus.OK);
  }

  @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
  @PutMapping("/update/{report_id}/{setter_id}")
  public ResponseEntity<Report> updateReport(
      @PathVariable(value = "report_id") Integer report_id,
      @PathVariable(value = "setter_id") Integer setter_id,
      @RequestBody ReportUpdateRequest reportUpdateRequest) {
    return new ResponseEntity<>(reportServiceImp.updateReport(reportUpdateRequest, setter_id), HttpStatus.OK);
  }

  @GetMapping("/search")
  public ResponseEntity<List<Report>> search(@SearchSpec Specification<Report> specs) {
    return new ResponseEntity<>(reportRepository.findAll(Specification.where(specs)), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Report> getById(
      @PathVariable(value = "id") Integer id) {
    Optional<Report> report = reportServiceImp.findById(id);
    return new ResponseEntity<>(report.get(), HttpStatus.OK);
  }

  @GetMapping("/new")
  public ResponseEntity<List<Report>> getNewReport() {
    List<Report> reports = reportServiceImp.newReport();
    return new ResponseEntity<>(reports, HttpStatus.OK);
  }

  @GetMapping("/assigned")
  public ResponseEntity<List<Report>> getAssignedReport() {
    List<Report> reports = reportServiceImp.assignedReport();
    return new ResponseEntity<>(reports, HttpStatus.OK);
  }

  @GetMapping("/inProcess")
  public ResponseEntity<List<Report>> getInProcessReport() {
    List<Report> reports = reportServiceImp.inProcessReport();
    return new ResponseEntity<>(reports, HttpStatus.OK);
  }

  @GetMapping("/solved")
  public ResponseEntity<List<Report>> getSolvedReport() {
    List<Report> reports = reportServiceImp.solvedReport();
    return new ResponseEntity<>(reports, HttpStatus.OK);
  }

  @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
  @GetMapping("/region/{region_id}")
  public ResponseEntity<List<Report>> getReportByREgion(
      @PathVariable(value = "region_id") Integer region_id) {
    List<Report> reports = reportServiceImp.getReportByRegion(region_id);
    return new ResponseEntity<>(reports, HttpStatus.OK);
  }
}
