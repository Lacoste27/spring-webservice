package com.aceky.reportit.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aceky.reportit.data.models.ReportType;

public interface ReportTypeRepository extends JpaRepository<ReportType, Integer> {

}
