package com.aceky.reportit.data.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;

import com.aceky.reportit.data.models.ReportImage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface ReportImageRepository extends JpaRepository<ReportImage, Integer> {

  @Query(value = "SELECT * FROM REPORTSIMAGES WHERE id_report = ?1", nativeQuery = true)
  public List<ReportImage> findByIdReport(Integer id_report);

}
