package ots.andy.group.horizonsproj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ots.andy.group.horizonsproj.entities.Parent;
import ots.andy.group.horizonsproj.repositories.ParentRepository;
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

    @PostMapping(path = "/parent")
    public ResponseEntity createParent(@RequestBody Parent parent){
        return parentService.addParent(parent);
    }

    @GetMapping(path="/parent/login")
    public ResponseEntity loginParent(@RequestBody Parent parent) {
        return parentService.loginParent(parent);
    }

    @GetMapping(path="/parent", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Parent> getAllParents(){
        return parentService.getAllParents();
    }

    @PutMapping(path="/parent")
    public ResponseEntity updateInfo(@RequestBody Parent parent) {
        return parentService.updateInfo(parent);
    }

}