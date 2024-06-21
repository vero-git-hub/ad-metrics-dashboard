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
                new AdPerformance("Campaign A", 1000, 300),
                new AdPerformance("Campaign B", 1500, 400),
                new AdPerformance("Campaign C", 1200, 350)
        );
    }

    static class AdPerformance {
        private String campaign;
        private int impressions;
        private int clicks;

        public AdPerformance(String campaign, int impressions, int clicks) {
            this.campaign = campaign;
            this.impressions = impressions;
            this.clicks = clicks;
        }

        public String getCampaign() {
            return campaign;
        }

        public void setCampaign(String campaign) {
            this.campaign = campaign;
        }

        public int getImpressions() {
            return impressions;
        }

        public void setImpressions(int impressions) {
            this.impressions = impressions;
        }

        public int getClicks() {
            return clicks;
        }

        public void setClicks(int clicks) {
            this.clicks = clicks;
        }
    }
}
