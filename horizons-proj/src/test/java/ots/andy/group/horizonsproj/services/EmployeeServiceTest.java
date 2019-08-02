package ots.andy.group.horizonsproj.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ots.andy.group.horizonsproj.entities.Employee;
import ots.andy.group.horizonsproj.repositories.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeServiceTest {
    EncryptionService enc = new EncryptionService();
    Employee e = new Employee("First", "Last", "Email", "password");
    Employee e2 = new Employee("First", "Last", "Email", enc.encryptionService().encode("password"));
    List<Employee> listWithEmployee = new ArrayList<Employee>() {
        {
            add(e2);
        }
    };
    List<Employee> emptyList = new ArrayList<Employee>();

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
        String encPass = enc.encryptionService().encode(e.getPassword());
        assertTrue(enc.encryptionService().matches(e.getPassword(), encPass));
    }

    private EmployeeService service;

    private EmployeeRepository repository = Mockito.mock(EmployeeRepository.class);

    @BeforeEach
    public void init()
    {
        service = new EmployeeService(repository);
    }

    @Test
    public void testRegisterEmployee() {
        when(repository.findByEmail(e.getEmail())).thenReturn(emptyList);
        boolean response = service.addEmployee(e);
        verify(repository, times(1)).save(e);
        assertTrue(response == true);
    }

    @Test
    public void testRegisterCollision() {
        when(repository.findByEmail(e.getEmail())).thenReturn(listWithEmployee);
        boolean response = service.addEmployee(e);
        verify(repository, times(1)).findByEmail(e.getEmail());
        assertTrue(response == false);
    }

    @Test
    public void testUpdateInfoEmpty() {
        when(repository.findByEmail(e.getEmail())).thenReturn(emptyList);
        boolean response = service.updateInfo(e);
        verify(repository, times(1)).findByEmail(e.getEmail());
        assertTrue(response == false);
    }

    @Test
    public void testUpdateInfo() {
        when(repository.findByEmail(e.getEmail())).thenReturn(listWithEmployee);
        boolean response = service.updateInfo(e);
        verify(repository, times(1)).findByEmail(e.getEmail());
        verify(repository, times(1)).save(e);
        assertTrue(response == true);
    }

    @Test
    public void testLoginInvalidEmail() {
        when(repository.findByEmail(e.getEmail())).thenReturn(emptyList);
        boolean response = service.loginEmployee(e);
        verify(repository, times(1)).findByEmail(e.getEmail());
        assertTrue(response == false);
    }

    @Test
    public void testLoginValid() {
        when(repository.findByEmail(e.getEmail())).thenReturn(listWithEmployee);
        boolean response = service.loginEmployee(e);
        verify(repository, times(1)).findByEmail(e.getEmail());
        assertTrue(response == true);
    }

    @Test
    public void testLoginInvalidPass() {
        e.setPassword("NOTMYPASS");
        when(repository.findByEmail(e.getEmail())).thenReturn(listWithEmployee);
        boolean response = service.loginEmployee(e);
        verify(repository, times(1)).findByEmail(e.getEmail());
        assertTrue(response == false);
    }
}