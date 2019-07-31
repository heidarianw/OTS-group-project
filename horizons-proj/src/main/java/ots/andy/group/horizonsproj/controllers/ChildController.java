package ots.andy.group.horizonsproj.controllers;

import org.springframework.web.bind.annotation.RestController;
import ots.andy.group.horizonsproj.entities.Child;
import ots.andy.group.horizonsproj.repositories.ChildRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
public class ChildController {

    private final ChildRepository repository;

    //@PersistenceContext
    //private EntityManager entityManager;

    ChildController(ChildRepository repository) { this.repository = repository; }

    List<Child> findAll() {
        return repository.findAll();
    }

}
