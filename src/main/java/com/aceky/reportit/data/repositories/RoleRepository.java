package com.aceky.reportit.data.repositories;

import java.util.Optional;

import com.aceky.reportit.data.models.ERole;
import com.aceky.reportit.data.models.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
