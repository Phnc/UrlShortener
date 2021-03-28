package com.tds.challenge.UrlShortener.model;

public class UrlResponse {
    private String originalURL;
    private String shortURL;

    public UrlResponse(String originalURL, String shortURL) {
        this.originalURL = originalURL;
        this.shortURL = shortURL;
    }

    public UrlResponse() {
    }

    public String getOriginalURL() {
        return originalURL;
    }

    public void setOriginalURL(String originalURL) {
        this.originalURL = originalURL;
    }

    public String getShortURL() {
        return shortURL;
    }

    public void setShortURL(String shortURL) {
        this.shortURL = shortURL;
    }

    @Override
    public String toString() {
        return "UrlResponse{" +
                "originalURL='" + originalURL + '\'' +
                ", shortURL='" + shortURL + '\'' +
                '}';
    }
}
