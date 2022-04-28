package com.aceky.reportit.data.repositories;

import com.aceky.reportit.data.models.AssignementHistories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignementHistoriesRepository extends JpaRepository<AssignementHistories, Integer> {
}
