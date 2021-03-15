package com.test.service;

import com.test.domain.FileDocument;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

public interface FileService {
    FileDocument saveFile(FileDocument file);
    String uploadFileToGridFS(InputStream in , String contentType);
    void removeFile(String id);
    Optional<FileDocument> getFileById(String id);
    List<FileDocument> listFilesByPage(int pageIndex, int pageSize);
}
