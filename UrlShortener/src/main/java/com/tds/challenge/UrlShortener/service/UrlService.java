package com.tds.challenge.UrlShortener.service;

import com.google.common.hash.Hashing;
import com.tds.challenge.UrlShortener.model.Url;
import com.tds.challenge.UrlShortener.repositories.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@Component
public class UrlService implements IUrlService{

    private UrlRepository urlRepository;

    @Autowired
    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }


    @Override
    public Url createShortURL(String url) {
        if(url != null && !url.isBlank() && !url.isEmpty()){

            String encoded = encodeURL(url);

            Url newUrl = new Url();
            newUrl.setOriginalURL(url);
            newUrl.setShortURL(encoded);
            newUrl.setCreatedAt(LocalDateTime.now());
            newUrl.setNumberOfVisits(0);

            Url toReturn = saveShortURL(newUrl);
            if(toReturn != null){
                return toReturn;
            }

        }
        return null;
    }

    @Override
    public Url saveShortURL(Url url) {
        Url toReturn = urlRepository.save(url);
        return toReturn;
    }

    @Override
    public Url getEncodedURL(String url) {
        Url toReturn = urlRepository.findByShortURL(url);
        return toReturn;
    }

    @Override
    public void updateNumberOfVisits(String url) {
        Url toUpdate = urlRepository.findByShortURL(url);
        toUpdate.setNumberOfVisits(toUpdate.getNumberOfVisits() + 1);
        urlRepository.save(toUpdate);
    }

    private String encodeURL(String url){
        String encoded = "";
        encoded = Hashing.crc32().hashString(url.concat(LocalDateTime.now().toString()), StandardCharsets.UTF_8).toString();
        return encoded;
    }

}
