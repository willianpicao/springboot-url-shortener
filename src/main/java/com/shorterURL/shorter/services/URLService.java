package com.shorterURL.shorter.services;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shorterURL.shorter.entities.URL;
import com.shorterURL.shorter.repository.URLRepository;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class URLService {

    @Autowired
    URLRepository urlRepository;

    public String shortenURL(String originalUrl, HttpServletRequest servletRequest) {
        String baseUrl = servletRequest.getRequestURL().toString().replace("/shorten-url", "");

        String shortCode;
        do {
            shortCode = generateShortCode();
        } while (urlRepository.findByShortUrl(shortCode).isPresent());

        URL url = new URL();
        url.setOriginalUrl(originalUrl);
        url.setShortUrl(shortCode); 
        url.setExpiration(LocalDateTime.now().plusMinutes(1));
        urlRepository.save(url);

        return baseUrl + "/" + shortCode;
    }

    public String getOriginalUrl(String shortUrl) {
        return urlRepository.findByShortUrl(shortUrl).isEmpty()
                ? "URL not found"
                : urlRepository.findByShortUrl(shortUrl).get().getExpiration().isAfter(LocalDateTime.now())
                        ? urlRepository.findByShortUrl(shortUrl).get().getOriginalUrl()
                        : "URL expired";
    }

    public String generateShortCode() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

}
