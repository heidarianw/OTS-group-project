package ots.andy.group.horizonsproj.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ots.andy.group.horizonsproj.entities.Employee;
import ots.andy.group.horizonsproj.repositories.EmployeeRepository;
import ots.andy.group.horizonsproj.services.EmployeeService;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private final EmployeeRepository repository;

    @Autowired
    private EmployeeService employeeService;

    EmployeeController(EmployeeRepository repository) { this.repository = repository; }

    List<Employee> findAll() {
        return repository.findAll();
    }

    @PostMapping(path="/employee")
    public ResponseEntity createEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @GetMapping(path="/employee/login")
    public ResponseEntity loginEmployee(@RequestBody Employee employee) {
        return employeeService.loginEmployee(employee);
    }

    @PutMapping(path="employee")
    public ResponseEntity updateInfo(@RequestBody Employee employee) {
        return employeeService.updateInfo(employee);
    }


}
