package com.aceky.reportit.data.payloads.request;

import com.aceky.reportit.data.models.Region;

import lombok.Data;

@Data
public class ModeratorLoginRequest {
    String username;
    String password;
    Region region;
}
