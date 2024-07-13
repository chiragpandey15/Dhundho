package com.example.dhundho.service;

import com.example.dhundho.model.File;
import com.example.dhundho.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;



@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileRepository fileRepository;

    @Override
    public void uploadImage(Long caseId, MultipartFile image) {
        String fileName = StringUtils.cleanPath(image.getOriginalFilename());
        try {
            File dbFile = new File(fileName, image.getContentType(), caseId);
            dbFile.setFileType("IMAGE");
            dbFile.setFilename(fileName);
            fileRepository.save(dbFile);
        }catch(Exception e){
            e.printStackTrace();
        } 
    }

    @Override
    public void uploadFir(Long caseId, MultipartFile fir) {
        String fileName = StringUtils.cleanPath(fir.getOriginalFilename());
        try {
            File dbFile = new File(fileName, fir.getContentType(), caseId);
            dbFile.setFileType("FIR");
            dbFile.setFilename(fileName);
            fileRepository.save(dbFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
