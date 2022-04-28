package com.aceky.reportit.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

import com.aceky.reportit.data.models.Region;
import com.aceky.reportit.data.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Getter
@Setter
public class UserDetailsImpl implements UserDetails {

  private Integer id;
  private String firstnaem;
  private String lastname;
  private String username;
  private String email;
  private Region region;
  @JsonIgnore
  private String password;

  private Collection<? extends GrantedAuthority> authorities;

  public UserDetailsImpl(Integer id, String firstname, String lastname, String username, String email, Region region,
      String password,
      Collection<? extends GrantedAuthority> authorities) {
    this.id = id;
    this.firstnaem = firstname;
    this.lastname = lastname;
    this.username = username;
    this.email = email;
    this.region = region;
    this.password = password;
    this.authorities = authorities;
  }

  public static UserDetailsImpl build(User user) {
    List<GrantedAuthority> authorities = user.getRoles().stream()
        .map(role -> new SimpleGrantedAuthority(role.getName().name()))
        .collect(Collectors.toList());

    return new UserDetailsImpl(
        user.getId(),
        user.getFirstname(),
        user.getLastname(),
        user.getUsername(),
        user.getEmail(),
        user.getRegion(),
        user.getPassword(),
        authorities);
  }

  @Override
  public boolean isAccountNonExpired() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public boolean isEnabled() {
    // TODO Auto-generated method stub
    return true;
  }
}
