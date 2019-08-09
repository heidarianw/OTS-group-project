package ots.andy.group.horizonsproj.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ots.andy.group.horizonsproj.entities.Child;
import ots.andy.group.horizonsproj.entities.Employee;
import ots.andy.group.horizonsproj.repositories.EmployeeRepository;
import ots.andy.group.horizonsproj.services.EmployeeService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class EmployeeControllerTest {
    private EmployeeController controller;

    private EmployeeService service = Mockito.mock(EmployeeService.class);
    private EmployeeRepository repo = Mockito.mock(EmployeeRepository.class);
    Employee d = new Employee ("a", "b", "c", "d");
    List<Employee> list = new ArrayList<Employee>() {
        {
            add(d);
        }
    };


    @BeforeEach
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeEach
    public void init()
    {
        controller = new EmployeeController(service, repo);
    }

    @Test
    public void testCreateEmployee() {
        ResponseEntity<Employee> resp = new ResponseEntity(d, HttpStatus.OK);
        when(service.addEmployee(any(Employee.class))).thenReturn(true);
        ResponseEntity<Employee> out = controller.createEmployee(d);
        verify(service, times(1)).addEmployee(d);
        assertTrue(resp.equals(out));
    }

    @Test
    public void testLoginEmp() {
        ResponseEntity<Employee> resp = new ResponseEntity(d, HttpStatus.OK);
        when(service.loginEmployee(any(Employee.class))).thenReturn(true);
        ResponseEntity<Employee> out = controller.loginEmployee(d);
        verify(service, times(1)).loginEmployee(d);
        assertTrue(resp.equals(out));
    }

    @Test
    public void testUpdateInfo() {
        ResponseEntity<Employee> resp = new ResponseEntity(d, HttpStatus.OK);
        when(service.updateInfo(any(Employee.class))).thenReturn(true);
        ResponseEntity<Employee> out = controller.updateInfo(d);
        verify(service, times(1)).updateInfo(d);
        assertTrue(resp.equals(out));
    }
}
