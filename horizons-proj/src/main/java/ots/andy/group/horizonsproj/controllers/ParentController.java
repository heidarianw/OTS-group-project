package ots.andy.group.horizonsproj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ots.andy.group.horizonsproj.entities.Parent;
import ots.andy.group.horizonsproj.repositories.ParentRepository;
import ots.andy.group.horizonsproj.services.EncryptionService;
import ots.andy.group.horizonsproj.services.ParentService;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
class ParentController {

    @Autowired
    private final ParentRepository repository;

    @Autowired
    private ParentService parentService;

    ParentController(ParentRepository repository) {
        this.repository = repository;
    }

    List<Parent> findAll() {
        return repository.findAll();
    }

    @PostMapping(path = "/parent/register")
    public ResponseEntity createParent(@RequestBody Parent parent){
        if (parentService.addParent(parent)) {
            return new ResponseEntity(parent, HttpStatus.OK); //status
        }
        else { return new ResponseEntity("Email already in use", HttpStatus.OK); }
    }

    @GetMapping(path="/parent/login")
    public ResponseEntity loginParent(@RequestBody Parent parent) {
        int response = parentService.loginParent(parent);
        if (response == 0) {
            return new ResponseEntity(HttpStatus.OK);
        }
        else if (response == 1) {
            return new ResponseEntity("Password incorrect", HttpStatus.OK);
        }
        return new ResponseEntity("Email does not exist", HttpStatus.OK);
    }


    @GetMapping(path="/parent/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Parent> getAllParents(){
        return parentService.getAllParents();
    }

}