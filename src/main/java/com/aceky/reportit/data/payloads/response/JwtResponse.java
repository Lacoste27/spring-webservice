package com.aceky.reportit.data.payloads.response;

import java.util.List;

import com.aceky.reportit.data.models.Region;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtResponse {
  private String token;
  private String type = "Bearer";
  private Integer id;
  private String firstname;
  private String lastname;
  private String username;
  private String email;
  private Region region;
  private List<String> roles;

  public JwtResponse(String accessToken, Integer id, String username, String firstname, String lastname, String email,
      Region region,
      List<String> roles) {
    this.token = accessToken;
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.username = username;
    this.email = email;
    this.region = region;
    this.roles = roles;
  }

}
