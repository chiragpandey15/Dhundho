package com.example.dhundho;

import com.example.dhundho.controller.CaseController;
import com.example.dhundho.model.Case;
import com.example.dhundho.model.CaseStatus;
import com.example.dhundho.service.CaseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class CaseControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CaseService caseService;

    @InjectMocks
    private CaseController caseController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(caseController).build();
    }

    @Test
    public void testGetAllCases() throws Exception {
        List<Case> cases = Arrays.asList(
                new Case(1L, "Case 1", "Description 1", CaseStatus.OPEN),
                new Case(2L, "Case 2", "Description 2", CaseStatus.IN_PROGRESS)
        );

        when(caseService.getAllCases()).thenReturn(cases);

        mockMvc.perform(get("/api/cases")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Case 1"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("Case 2"));
    }

    @Test
    public void testGetCaseById() throws Exception {
        Long caseId = 1L;
        Case caseObj = new Case(caseId, "Test Case", "Test Description", CaseStatus.OPEN);

        when(caseService.getCaseById(caseId)).thenReturn(caseObj);

        mockMvc.perform(get("/api/cases/{id}", caseId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(caseId))
                .andExpect(jsonPath("$.name").value("Test Case"));
    }

    
}
