package ots.andy.group.horizonsproj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ots.andy.group.horizonsproj.entities.Allergy;
import ots.andy.group.horizonsproj.services.AllergyService;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class AllergyController {

    @Autowired
    private AllergyService service;

    @GetMapping(path="/allergy", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Allergy> getAllAllergy(){
        List<Allergy> response = service.getAllAllergy();
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
