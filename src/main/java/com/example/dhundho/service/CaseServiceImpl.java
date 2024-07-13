package com.example.dhundho.service;

import com.example.dhundho.model.Case;
import com.example.dhundho.model.CaseStatus;
import com.example.dhundho.repository.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaseServiceImpl implements CaseService {

    @Autowired
    private CaseRepository caseRepository;

    @Override
    public Case createCase(Case newCase) {
        // Initialize case status to OPEN when creating a new case
        newCase.setStatus(CaseStatus.OPEN);
        return caseRepository.save(newCase);
    }

    @Override
    public Case updateCase(Long caseId, Case updatedCase) {
        Optional<Case> existingCaseOptional = caseRepository.findById(caseId);
        if (existingCaseOptional.isPresent()) {
            updatedCase.setId(caseId);
            return caseRepository.save(updatedCase);
        }
        throw new IllegalArgumentException("Case with ID " + caseId + " not found.");
    }

    @Override
    public Case closeCase(Long caseId) {
        Optional<Case> existingCaseOptional = caseRepository.findById(caseId);
        if (existingCaseOptional.isPresent()) {
            Case existingCase = existingCaseOptional.get();
            existingCase.setStatus(CaseStatus.CLOSED);
            return caseRepository.save(existingCase);
        }
        throw new IllegalArgumentException("Case with ID " + caseId + " not found.");
    }

    @Override
    public void reportFake(Long caseId) {
        Optional<Case> existingCaseOptional = caseRepository.findById(caseId);
        if (existingCaseOptional.isPresent()) {
            Case existingCase = existingCaseOptional.get();
            existingCase.setStatus(CaseStatus.FAKE);
            caseRepository.delete(existingCase);
        } else {
            throw new IllegalArgumentException("Case with ID " + caseId + " not found.");
        }
    }

    @Override
    public List<Case> getAllCases() {
        return caseRepository.findAll();
    }

    @Override
    public Case getCaseById(Long caseId) {
        Optional<Case> caseOptional = caseRepository.findById(caseId);
        return caseOptional.orElse(null);
    }
}
