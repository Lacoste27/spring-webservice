package com.aceky.reportit.data.payloads.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RegionsRequest {
    @NotBlank
    @NotNull
    Integer id;
    @NotBlank
    @NotNull
    String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
