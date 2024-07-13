package com.example.dhundho;

import com.example.dhundho.controller.FileController;
import com.example.dhundho.service.FileService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class FileControllerTest {

    private MockMvc mockMvc;

    @Mock
    private FileService fileService;

    @InjectMocks
    private FileController fileController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(fileController).build();
    }

    @Test
    public void testUploadImage() throws Exception {
        MockMultipartFile imageFile = new MockMultipartFile("image", "test.jpg", MediaType.IMAGE_JPEG_VALUE, "Spring Framework".getBytes());

        mockMvc.perform(multipart("/api/files/uploadImage/{caseId}", 1L)
                .file(imageFile))
                .andExpect(status().isOk());
    }

    @Test
    public void testUploadFir() throws Exception {
        MockMultipartFile firFile = new MockMultipartFile("fir", "test.txt", MediaType.TEXT_PLAIN_VALUE, "Test FIR content".getBytes());

        mockMvc.perform(multipart("/api/files/uploadFir/{caseId}", 1L)
                .file(firFile))
                .andExpect(status().isOk());
    }

    
}
