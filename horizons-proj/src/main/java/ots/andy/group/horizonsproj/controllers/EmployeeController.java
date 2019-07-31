package ots.andy.group.horizonsproj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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

    @PostMapping(path="/employee/register")
    public ResponseEntity createEmployee(@RequestBody Employee employee){
        if (employeeService.addEmployee(employee)) {
            return new ResponseEntity(HttpStatus.OK); //status
        }
        else { return new ResponseEntity("Email already in use", HttpStatus.OK); }
    }

    @GetMapping(path="/employee/login")
    public ResponseEntity loginEmployee(@RequestBody Employee employee) {
        int response = employeeService.loginEmployee(employee);
        if (response == 0) {
            return new ResponseEntity(HttpStatus.OK);
        }
        else if (response == 1) {
            return new ResponseEntity("Password incorrect", HttpStatus.OK);
        }
        return new ResponseEntity("Email does not exist", HttpStatus.OK);
    }

}
