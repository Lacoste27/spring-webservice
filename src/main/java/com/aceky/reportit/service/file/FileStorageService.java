package com.aceky.reportit.service.file;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public interface FileStorageService {
    public void init();

    public String save(MultipartFile file, String filename);

    public Resource load(String filename);

    public void deleteAll();

    public Stream<Path> loadAll();

    public List<MultipartFile> converttomulitpart(String listeimage);    
}
