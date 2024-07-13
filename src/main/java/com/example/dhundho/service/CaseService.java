package com.example.dhundho.service;

import com.example.dhundho.model.Case;

import java.util.List;

public interface CaseService {
    Case createCase(Case newCase);
    Case updateCase(Long caseId, Case updatedCase);
    Case closeCase(Long caseId);
    void reportFake(Long caseId);
    List<Case> getAllCases();
    Case getCaseById(Long caseId);
}
