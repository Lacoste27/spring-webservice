package com.aceky.reportit.service.file;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import javax.servlet.ServletContext;

import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageServiceImpl implements FileStorageService {
    @Autowired
    ServletContext context;
    private final Path root = Paths.get("src/resources/uploads/");

    @Override
    public void init() {
        try {
            Files.createDirectory(root);
        } catch (IOException e) {
            System.out.println(e.toString());
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    @Override
    public String save(MultipartFile file, String filename) {
        try {
            if (!root.toFile().exists()) {
                init();
            }
            System.out.println("loading file ");
            Files.copy(file.getInputStream(),
                    this.root.resolve(file.getOriginalFilename()));
            File oldFile = new File(root.resolve(file.getOriginalFilename()).toString());
            File newFile = new File(root.resolve(filename).toString());
            oldFile.renameTo(newFile);
            return root.resolve(filename).toString();
        } catch (Exception e) {
            System.out.println(e.toString());
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

    @Override
    public Resource load(String filename) {
        try {
            Path file = root.resolve(filename);
            System.out.println(file.toString());
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        FileSystemUtils.deleteRecursively(root.toFile());
    }

    @Override
    public Stream<Path> loadAll() {
        // TODO Auto-generated method stub
        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Could not load the files!");
        }
    }

    @Override
    public List<MultipartFile> converttomulitpart(String listeimage) {
        List<String> filesbase64 = new ArrayList<>() ;
        String[] filesdata = listeimage.split(",");

        for (int index = 1; index < filesdata.length; index += 2) {
            filesbase64.add(filesdata[index].split("\"")[0]) ;
        }

        List<MultipartFile> retour = new ArrayList<>() ;

        for (String file : filesbase64) {
            byte[] filesbytes = Base64.getDecoder().decode(file) ;
            String extension = "image/jpeg" ;
            String filename = new Date().getTime() + ".jpeg" ;
            MulitPartCustom custom = new MulitPartCustom(filesbytes, filename, extension) ;
            retour.add(custom) ;
        }

        return retour;
    }
}
