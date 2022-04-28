package com.aceky.reportit.service.file;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public class MulitPartCustom implements MultipartFile {
    private byte[] bytefiles ;
    private String filename ;
    private String extension ;

    public MulitPartCustom(byte[] bytefiles, String filename, String extension) {
        this.bytefiles = bytefiles ;
        this.filename = filename ;
        this.extension = extension ;
    }

    public void setByteFiles(byte[] bytes) {
        this.bytefiles = bytes ;
    }

    public void setFileName(String name) {
        this.filename = name ;
    }

    public void setExtension(String extension) {
        this.extension = extension ;
    }

    public String getExtension() {
        return this.extension ;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return bytefiles;
    }

    @Override
    public String getContentType() {
        return this.getExtension();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(this.bytefiles);
    }

    @Override
    public String getName() {
        return filename;
    }

    @Override
    public String getOriginalFilename() {
        return filename;
    }

    @Override
    public long getSize() {
        return bytefiles.length;
    }

    @Override
    public boolean isEmpty() {
        return bytefiles == null || bytefiles.length == 0;
    }

    @Override
    public void transferTo(File dest) throws IOException, IllegalStateException {
        try(FileOutputStream f = new FileOutputStream(dest)) {
            f.write(bytefiles);
        }
    }
    
}
