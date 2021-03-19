package com.tds.challenge.UrlShortener.controller;

import com.tds.challenge.UrlShortener.model.Url;
import com.tds.challenge.UrlShortener.model.UrlErrorResponse;
import com.tds.challenge.UrlShortener.model.UrlResponse;
import com.tds.challenge.UrlShortener.service.IUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class UrlShortenerController {

    private IUrlService urlService;

    @Autowired
    public UrlShortenerController(IUrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/generate")
    public ResponseEntity<?> generateShortLink(@RequestBody String url){
        Url toReturn = urlService.createShortURL(url);

        if(toReturn != null){
            UrlResponse urlResponse = new UrlResponse();
            urlResponse.setOriginalURL(toReturn.getOriginalURL());
            urlResponse.setShortURL(toReturn.getShortURL());
            return new ResponseEntity<UrlResponse>(urlResponse, HttpStatus.OK);
        }
        UrlErrorResponse errorResponse = new UrlErrorResponse();
        errorResponse.setStatus("500");
        errorResponse.setError("There was an error processing your request. Please try again later.");
        return new ResponseEntity<UrlErrorResponse>(errorResponse, HttpStatus.OK);
    }

    @GetMapping("/{shortURL}")
    public ResponseEntity<?> redirect(@PathVariable String shortURL, HttpServletResponse response) throws IOException {

        if(shortURL != null & !shortURL.isEmpty() && !shortURL.isBlank()){
            Url toReturn = urlService.getEncodedURL(shortURL);

            if(toReturn == null){
                UrlErrorResponse errorResponse = new UrlErrorResponse();
                errorResponse.setStatus("400");
                errorResponse.setError("The required URL does not exist.");
                return new ResponseEntity<UrlErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
            }

            response.sendRedirect(toReturn.getOriginalURL());

        } else{
            UrlErrorResponse errorResponse = new UrlErrorResponse();
            errorResponse.setStatus("400");
            errorResponse.setError("The URL is invalid.");

            return new ResponseEntity<UrlErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
        }

        return null;

    }
}
