package ots.andy.group.horizonsproj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ots.andy.group.horizonsproj.entities.Child;
import ots.andy.group.horizonsproj.entities.Parent;
import ots.andy.group.horizonsproj.repositories.ChildRepository;

import java.util.List;

@RestController
public class ChildController {

    private final ChildRepository repository;

    ChildController(ChildRepository repository) { this.repository = repository; }

    List<Child> findAll() {
        return repository.findAll();
    }
}
