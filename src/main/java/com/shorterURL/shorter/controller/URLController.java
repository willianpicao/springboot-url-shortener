package com.shorterURL.shorter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shorterURL.shorter.dto.ShortenUrlRequest;
import com.shorterURL.shorter.services.URLService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/shorten-url")
public class URLController {

    @Autowired
    URLService urlService;

    @PostMapping
    public ResponseEntity<String> shortenUrl(@RequestBody ShortenUrlRequest request,
            HttpServletRequest servletRequest) {
        String url = urlService.shortenURL(request.url(), servletRequest);
        return ResponseEntity.ok(url);
    }

    
}
