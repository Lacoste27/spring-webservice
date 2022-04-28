package com.aceky.reportit.data.payloads.request;

import java.util.Set;

import javax.validation.constraints.*;

import com.aceky.reportit.data.models.Region;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequest {
  @NotBlank
  private String firstname;
  @NotBlank
  private String lastname;
  @NotBlank
  @Size(min = 3, max = 20)
  private String username;
  @NotBlank
  @Size(max = 50)
  @Email
  private String email;
  @NotBlank
  @Size(min = 6, max = 40)
  private String password;
  Region region;
  private Set<String> role;
}
