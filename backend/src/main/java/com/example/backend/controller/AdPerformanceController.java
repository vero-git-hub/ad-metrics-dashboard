package com.example.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AdPerformanceController {

    @GetMapping("/ad-performance")
    public List<AdPerformance> getAdPerformance() {
        return Arrays.asList(
                new AdPerformance("Page A", 4000, 2400),
                new AdPerformance("Page B", 3000, 1398)
        );
    }

    static class AdPerformance {
        private String name;
        private int uv;
        private int pv;

        public AdPerformance(String name, int uv, int pv) {
            this.name = name;
            this.uv = uv;
            this.pv = pv;
        }

        // Getters and setters

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getUv() {
            return uv;
        }

        public void setUv(int uv) {
            this.uv = uv;
        }

        public int getPv() {
            return pv;
        }

        public void setPv(int pv) {
            this.pv = pv;
        }
    }
}
