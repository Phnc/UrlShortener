package com.tds.challenge.UrlShortener.model;

import java.time.LocalDateTime;

public class UrlStatisticsResponse {

    private String shortURL;
    private String originalURL;
    private LocalDateTime createdAt;
    private int totalVisits;
    private double visitsPerDayMean;

    public UrlStatisticsResponse(String shortURL, String originalURL, LocalDateTime createdAt, int totalVisits, double visitsPerDayMean) {
        this.shortURL = shortURL;
        this.originalURL = originalURL;
        this.createdAt = createdAt;
        this.totalVisits = totalVisits;
        this.visitsPerDayMean = visitsPerDayMean;
    }

    public UrlStatisticsResponse() {
    }

    public String getShortURL() {
        return shortURL;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setShortURL(String shortURL) {
        this.shortURL = shortURL;
    }

    public String getOriginalURL() {
        return originalURL;
    }

    public void setOriginalURL(String originalURL) {
        this.originalURL = originalURL;
    }

    public int getTotalVisits() {
        return totalVisits;
    }

    public void setTotalVisits(int totalVisits) {
        this.totalVisits = totalVisits;
    }

    public double getVisitsPerDayMean() {
        return visitsPerDayMean;
    }

    public void setVisitsPerDayMean(double visitsPerDayMean) {
        this.visitsPerDayMean = visitsPerDayMean;
    }

    @Override
    public String toString() {
        return "UrlStatisticsResponse{" +
                "shortURL='" + shortURL + '\'' +
                ", originalURL='" + originalURL + '\'' +
                ", createdAt=" + createdAt +
                ", totalVisits=" + totalVisits +
                ", visitsPerDayMean=" + visitsPerDayMean +
                '}';
    }
}
