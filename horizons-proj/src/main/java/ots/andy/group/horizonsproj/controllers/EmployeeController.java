package ots.andy.group.horizonsproj.controllers;

import ots.andy.group.horizonsproj.entities.Employee;
import ots.andy.group.horizonsproj.repositories.EmployeeRepository;

import java.util.List;

public class EmployeeController {

    private final EmployeeRepository repository;

    EmployeeController(EmployeeRepository repository) { this.repository = repository; }

    List<Employee> findAll() {
        return repository.findAll();
    }

}
