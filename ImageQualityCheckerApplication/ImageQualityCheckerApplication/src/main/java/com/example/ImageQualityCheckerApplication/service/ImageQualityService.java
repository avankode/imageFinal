package com.example.ImageQualityCheckerApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class ImageQualityService {

    @Value("${flask.server.url}")
    private String flaskServerUrl;

    private final RestTemplate restTemplate;

    @Autowired
    public ImageQualityService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> evaluateImageQuality(String imageUrl) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Prepare request body (in this case, you can just pass the imageUrl as query param)
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Make HTTP GET request to Flask server's /evaluate endpoint
        String evaluateUrl = flaskServerUrl + "/evaluate?imageUrl=" + imageUrl;
        ResponseEntity<String> response = restTemplate.exchange(evaluateUrl, HttpMethod.GET, entity, String.class);

        return response;
    }
}
