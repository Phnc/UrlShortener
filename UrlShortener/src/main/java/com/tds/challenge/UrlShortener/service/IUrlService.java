package com.tds.challenge.UrlShortener.service;

import com.tds.challenge.UrlShortener.model.Url;
import org.springframework.stereotype.Service;

@Service
public interface IUrlService {

    public Url createShortURL(String url);

    public Url saveShortURL(Url url);

    public  Url getEncodedURL(String url);

    public void updateNumberOfVisits (String url);

}
