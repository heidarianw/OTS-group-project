package ots.andy.group.horizonsproj.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ots.andy.group.horizonsproj.entities.Parent;
import ots.andy.group.horizonsproj.repositories.ParentRepository;

@RestController
class ParentController {

    private final ParentRepository repository;

    ParentController(ParentRepository repository) {
        this.repository = repository;
    }


    List<Parent> findAll() {
        return repository.findAll();
    }

}