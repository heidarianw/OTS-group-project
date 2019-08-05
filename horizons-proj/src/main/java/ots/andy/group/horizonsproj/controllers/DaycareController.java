package ots.andy.group.horizonsproj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ots.andy.group.horizonsproj.entities.Daycare;
import ots.andy.group.horizonsproj.services.DaycareService;

import java.util.List;

@RestController
public class DaycareController {

    @Autowired
    private DaycareService service;

    @GetMapping(path="/daycare", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Daycare> getAllDaycare(){
        List<Daycare> response = service.getAllDaycare();
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
