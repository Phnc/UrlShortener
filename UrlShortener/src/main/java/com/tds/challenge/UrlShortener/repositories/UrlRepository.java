package com.tds.challenge.UrlShortener.repositories;

import com.tds.challenge.UrlShortener.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {

    public Url findByShortURL(String shortURL);

}
