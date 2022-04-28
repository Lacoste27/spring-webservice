package com.aceky.reportit.data.payloads.request;

import lombok.Data;

@Data
public class ImageRequest {
    int id;
    String name;
    String url;

    public ImageRequest(String name, String url) {
        this.name = name;
        this.url = url;
    }

}
