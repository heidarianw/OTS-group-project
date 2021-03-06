package ots.andy.group.horizonsproj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ots.andy.group.horizonsproj.entities.Parent;
import ots.andy.group.horizonsproj.entities.Status;
import ots.andy.group.horizonsproj.repositories.StatusRepository;
import ots.andy.group.horizonsproj.services.StatusService;

import java.util.List;

@RestController
@CrossOrigin(origins= {"http://localhost:3000", "http://horizons-frontend-bucket-1.s3-website-us-west-1.amazonaws.com"})
public class StatusController {

    private final StatusService service;
    @Autowired
    public StatusController(StatusService statusService)
    {
        this.service = statusService;
    }

    @GetMapping(path="/status", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Status> getAllStatus(){
        List<Status> response = service.getAllStatus();
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
