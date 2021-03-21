package com.tds.challenge.UrlShortener.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;

import java.net.URI;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class UrlShortenerControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void generateShortLink() throws Exception {
        final String baseURL = "http://localhost:8080/generate";
        URI uri = new URI(baseURL);
        String longURL = "https://github.com/Phnc/UrlShortener";

        HttpEntity<String> request = new HttpEntity<>(longURL);

        ResponseEntity result = this.restTemplate.postForEntity(uri,request,String.class);
        assertTrue("Short url not generated", result.toString().contains("http://localhost:8080/"));
        System.out.println("Url generation test passed");

    }

    @Test
    public void redirect() throws Exception{
        final String baseURL = "http://localhost:8080/generate";
        URI uri = new URI(baseURL);
        String longURL = "https://github.com/Phnc/UrlShortener";
        HttpEntity<String> request = new HttpEntity<>(longURL);
        ResponseEntity result = this.restTemplate.postForEntity(uri,request,String.class);


        int shortURLBegin = result.toString().lastIndexOf("http://localhost:8080/") + 22;
        int shortURLEnd = shortURLBegin + 8;
        String shortURL = result.toString().substring(shortURLBegin, shortURLEnd);

        final String baseURLRedirect = "http://localhost:8080/".concat(shortURL);

        ResponseEntity resultRedirect = this.restTemplate.getForEntity(baseURLRedirect, String.class);

        assertTrue("Could not redirect, the address does not match", resultRedirect.toString().contains("github.com"));
        System.out.println("Redirect test passed");

    }

    @Test
    public void getUrlStatistics() throws Exception{
        final String baseURL = "http://localhost:8080/generate";
        URI uri = new URI(baseURL);
        String longURL = "https://github.com/Phnc/UrlShortener";
        HttpEntity<String> request = new HttpEntity<>(longURL);
        ResponseEntity result = this.restTemplate.postForEntity(uri,request,String.class);


        int shortURLBegin = result.toString().lastIndexOf("http://localhost:8080/") + 22;
        int shortURLEnd = shortURLBegin + 8;
        String shortURL = result.toString().substring(shortURLBegin, shortURLEnd);

        final String baseURLRedirect = "http://localhost:8080/".concat(shortURL);

        this.restTemplate.getForEntity(baseURLRedirect, String.class);
        this.restTemplate.getForEntity(baseURLRedirect, String.class);
        this.restTemplate.getForEntity(baseURLRedirect, String.class);

        final String baseURLStatistics = "http://localhost:8080/statistics/".concat(shortURL);

        ResponseEntity<String> resultStatistics = this.restTemplate.getForEntity(baseURLStatistics, String.class);
        assertTrue("Could not find statistics for this URL", resultStatistics.toString().contains("createdAt") && resultStatistics.toString().contains("totalVisits"));
        System.out.println("Statistics test passed");
    }
}