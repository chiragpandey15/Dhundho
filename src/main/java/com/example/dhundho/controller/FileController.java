package com.example.dhundho.controller;

import com.example.dhundho.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/uploadImage/{caseId}")
    public ResponseEntity<Void> uploadImage(@PathVariable("caseId") Long caseId, @RequestParam("image") MultipartFile image) {
        fileService.uploadImage(caseId, image);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/uploadFir/{caseId}")
    public ResponseEntity<Void> uploadFir(@PathVariable("caseId") Long caseId, @RequestParam("fir") MultipartFile fir) {
        fileService.uploadFir(caseId, fir);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
