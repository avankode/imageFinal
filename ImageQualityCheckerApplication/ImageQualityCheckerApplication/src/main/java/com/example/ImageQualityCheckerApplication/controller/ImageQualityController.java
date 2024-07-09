package com.example.ImageQualityCheckerApplication.controller;

import com.example.ImageQualityCheckerApplication.service.ImageQualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageQualityController {

    private final ImageQualityService imageQualityService;

    @Autowired
    public ImageQualityController(ImageQualityService imageQualityService) {
        this.imageQualityService = imageQualityService;
    }

    @GetMapping("/evaluateImage")
    public ResponseEntity<String> evaluateImage(@RequestParam String imageUrl) {
        ResponseEntity<String> response = imageQualityService.evaluateImageQuality(imageUrl);
        return response;
    }
}
