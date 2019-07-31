package ots.andy.group.horizonsproj.controllers;

import java.util.List;

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