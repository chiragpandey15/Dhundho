package com.example.dhundho.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    void uploadImage(Long caseId, MultipartFile image);
    void uploadFir(Long caseId, MultipartFile fir);
}
