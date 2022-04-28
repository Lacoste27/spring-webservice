package com.aceky.reportit.data.repositories;

import java.util.List;

//import java.util.Optional;

import com.aceky.reportit.data.models.Report;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface ReportRepository extends JpaRepository<Report, Integer>, JpaSpecificationExecutor<Report> {
    @Query(value = "SELECT * FROM reports WHERE user_id = ?1", nativeQuery = true)
    public List<Report> findByIdUser(Integer id_user);

    @Query(value = "SELECT * FROM reports WHERE region_id = ?1 ORDER BY created_at", nativeQuery = true)
    public List<Report> findByIdRegion(Integer id_region);

    @Query(value = "SELECT * FROM reports WHERE state = 0 ", nativeQuery = true)
    public List<Report> newReport();

    @Query(value = "SELECT * FROM reports WHERE state = 1 ", nativeQuery = true)
    public List<Report> assignedReport();

    @Query(value = "SELECT * FROM reports WHERE state = 2 ", nativeQuery = true)
    public List<Report> inProcess();

    @Query(value = "SELECT * FROM reports WHERE state = 3 ", nativeQuery = true)
    public List<Report> solved();
}