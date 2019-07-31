package ots.andy.group.horizonsproj.controllers;

import com.sun.tools.javac.comp.Resolve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ots.andy.group.horizonsproj.entities.Parent;
import ots.andy.group.horizonsproj.repositories.ParentRepository;
import ots.andy.group.horizonsproj.services.ParentService;

import java.util.List;

@RestController
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
        parentService.addParent(parent);
        return new ResponseEntity(HttpStatus.OK); //status
    }

    @GetMapping(path="/parent/all/{var}")
    public String getAllParents(){
        return parentService.getAllParents();
    }

}