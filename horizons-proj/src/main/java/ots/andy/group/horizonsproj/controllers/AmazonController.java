package ots.andy.group.horizonsproj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ots.andy.group.horizonsproj.services.AmazonService;

import java.io.IOException;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class AmazonController {

    @Autowired
    private AmazonService amazonService;

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestPart(value = "file") MultipartFile multipartFile) throws IOException {
        String url = amazonService.upload(multipartFile);
        return new ResponseEntity(url, HttpStatus.OK);
    }
}
