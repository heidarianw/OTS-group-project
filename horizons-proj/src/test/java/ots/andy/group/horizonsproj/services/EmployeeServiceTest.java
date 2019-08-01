package ots.andy.group.horizonsproj.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ots.andy.group.horizonsproj.entities.Employee;
import ots.andy.group.horizonsproj.repositories.EmployeeRepository;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    @Autowired
    EmployeeService employeeService;
    Employee e = new Employee("First", "Last", "Email", "password");

    @Test
    void getEmployeeInfo() {
        assertTrue(e.getFirst().equals("First"));
        assertTrue(e.getLast().equals("Last"));
        assertTrue(e.getEmail().equals("Email"));
        assertTrue(e.getPassword().equals("password"));
    }

    @Test
    void getAndSetEmployeeInfo() {
        e.setFirst("f");
        e.setLast("l");
        e.setEmail("e");
        e.setPassword("p");
        assertTrue(e.getFirst().equals("f"));
        assertTrue(e.getLast().equals("l"));
        assertTrue(e.getEmail().equals("e"));
        assertTrue(e.getPassword().equals("p"));
    }

    @Test
    void encryptPass() {
        EncryptionService encryptionService = new EncryptionService();
        String enc = encryptionService.encryptionService().encode(e.getPassword());
        assertTrue(encryptionService.encryptionService().matches(e.getPassword(), enc));
    }

}