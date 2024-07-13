package com.example.dhundho.controller;

import com.example.dhundho.model.Case;
import com.example.dhundho.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cases")
public class CaseController {

    @Autowired
    private CaseService caseService;

    @GetMapping
    public ResponseEntity<List<Case>> getAllCases() {
        List<Case> cases = caseService.getAllCases();
        return new ResponseEntity<>(cases, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Case> getCaseById(@PathVariable("id") Long caseId) {
        Case caseObj = caseService.getCaseById(caseId);
        if (caseObj != null) {
            return new ResponseEntity<>(caseObj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Case> createCase(@RequestBody Case newCase) {
        Case createdCase = caseService.createCase(newCase);
        return new ResponseEntity<>(createdCase, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Case> updateCase(@PathVariable("id") Long caseId, @RequestBody Case updatedCase) {
        Case updated = caseService.updateCase(caseId, updatedCase);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @PatchMapping("/{id}/close")
    public ResponseEntity<Case> closeCase(@PathVariable("id") Long caseId) {
        Case closed = caseService.closeCase(caseId);
        return new ResponseEntity<>(closed, HttpStatus.OK);
    }

    @DeleteMapping("/{id}/reportFake")
    public ResponseEntity<Void> reportFake(@PathVariable("id") Long caseId) {
        caseService.reportFake(caseId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
