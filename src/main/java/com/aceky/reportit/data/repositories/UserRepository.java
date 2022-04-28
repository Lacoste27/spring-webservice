package com.aceky.reportit.data.repositories;

import java.util.Optional;

import com.aceky.reportit.data.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);

  Optional<User> findById(Integer id);
  
  @Query(value = "SELECT COUNT(*) FROM users WHERE username = ?1 AND region_id = ?2 ", nativeQuery = true)
  public Integer findModByRegion(String username ,Integer region_id );

}
