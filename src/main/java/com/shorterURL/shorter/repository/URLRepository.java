package com.shorterURL.shorter.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shorterURL.shorter.entities.URL;

public interface URLRepository extends JpaRepository<URL, Long> {
    Optional<URL> findByShortUrl(String shortUrl);
}
