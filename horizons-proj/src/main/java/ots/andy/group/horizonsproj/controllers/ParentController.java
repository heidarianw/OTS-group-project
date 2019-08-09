package ots.andy.group.horizonsproj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ots.andy.group.horizonsproj.entities.Parent;
import ots.andy.group.horizonsproj.repositories.ParentRepository;
import ots.andy.group.horizonsproj.services.ParentService;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins= {"http://localhost:3000", "http://horizons-frontend-bucket-1.s3-website-us-west-1.amazonaws.com"})
class ParentController {

    @Autowired
    private ParentRepository repository;

    @Autowired
    private ParentService parentService;

    ParentController() {}

    ParentController(ParentRepository repository) {
        this.repository = repository;
    }
    ParentController(ParentService service, ParentRepository repository) {
        this.repository = repository;
        this.parentService = service;
    }

    List<Parent> findAll() {
        return repository.findAll();
    }

    @PostMapping(path = "/parent")
    public ResponseEntity<Parent> createParent(@RequestBody Parent parent){
        if (parentService.addParent(parent)) return new ResponseEntity(parent, HttpStatus.OK);
        return new ResponseEntity( HttpStatus.CONFLICT);
    }

    @PostMapping(path="/parent/login")
    public ResponseEntity<Parent> loginParent(@RequestBody Parent parent) {
        if (parentService.loginParent(parent)) return new ResponseEntity(parent, HttpStatus.OK);
        return new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping(path="/parent", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Parent> getAllParents(){
        return parentService.getAllParents();
    }


    @GetMapping(path="/parent/{childID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Parent> getParentsOfChild(@PathVariable int childID){
        Set<Parent> result = parentService.getParentsOfChild(childID);
        if (!result.isEmpty()){
            return new ResponseEntity(result, HttpStatus.OK);
        } else return new ResponseEntity(HttpStatus.CONFLICT);
    }

    @PutMapping(path="/parent")
    public ResponseEntity<Parent> updateInfo(@RequestBody Parent parent) {
        if (parentService.updateInfo(parent)) return new ResponseEntity(parent, HttpStatus.OK);
        return new ResponseEntity(HttpStatus.CONFLICT);
    }

}