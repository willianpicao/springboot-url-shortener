package com.shorterURL.shorter.controller;

import com.shorterURL.shorter.services.URLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RedirectController {

    @Autowired
    private URLService urlService;

    @GetMapping("/{shortCode}")
    public ResponseEntity<String> redirectToOriginalUrl(@PathVariable String shortCode) {
        String originalUrl = urlService.getOriginalUrl(shortCode);

        if (originalUrl.equals("URL not found")) {
            String html = "<h1 style='color:red;'>404 - URL não encontrada</h1>"
                        + "<p>A URL informada não existe ou nunca foi registrada.</p>";
            return ResponseEntity.status(404).body(html);
        }

        if (originalUrl.equals("URL expired")) {
            String html = "<h1 style='color:orange;'>410 - URL expirada</h1>"
                        + "<p>Essa URL encurtada expirou e não pode mais ser acessada.</p>";
            return ResponseEntity.status(410).body(html);
        }

        return ResponseEntity.status(302)
                .header("Location", originalUrl)
                .build();
    }
}
