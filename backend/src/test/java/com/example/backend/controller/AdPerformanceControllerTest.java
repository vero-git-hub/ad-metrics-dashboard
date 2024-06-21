package com.example.backend.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AdPerformanceController.class)
public class AdPerformanceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdPerformanceController adPerformanceController;

    @Test
    public void shouldReturnAdPerformanceData() throws Exception {
        // Arrange
        given(adPerformanceController.getAdPerformance()).willReturn(Arrays.asList(
                new AdPerformanceController.AdPerformance("Campaign A", 1000, 200),
                new AdPerformanceController.AdPerformance("Campaign B", 1500, 300)
        ));

        // Act & Assert
        mockMvc.perform(get("/api/ad-performance"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].campaign").value("Campaign A"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].impressions").value(1000))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].clicks").value(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].campaign").value("Campaign B"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].impressions").value(1500))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].clicks").value(300));
    }
}