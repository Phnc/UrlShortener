package com.tds.challenge.UrlShortener.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.time.LocalDateTime;

public class Url {

    @Id
    @GeneratedValue
    private Long id;
    @Lob
    private String originalURL;
    private String shortURL;
    private LocalDateTime createdAt;

    public Url(Long id, String originalURL, String shortURL, LocalDateTime createdAt) {
        this.id = id;
        this.originalURL = originalURL;
        this.shortURL = shortURL;
        this.createdAt = createdAt;
    }

    public Url(String originalURL, String shortURL, LocalDateTime createdAt) {
        this.originalURL = originalURL;
        this.shortURL = shortURL;
        this.createdAt = createdAt;
    }

    public Url() {
    }

    @Override
    public String toString() {
        return "Url{" +
                "id=" + id +
                ", originalURL='" + originalURL + '\'' +
                ", shortURL='" + shortURL + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
