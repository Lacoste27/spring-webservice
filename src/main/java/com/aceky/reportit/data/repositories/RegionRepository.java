package com.aceky.reportit.data.repositories;

import com.aceky.reportit.data.models.Region;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {
}
