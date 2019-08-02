package ots.andy.group.horizonsproj.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ots.andy.group.horizonsproj.entities.Parent;
import ots.andy.group.horizonsproj.repositories.ParentRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ParentServiceTest {
    EncryptionService enc = new EncryptionService();
    Parent p = new Parent("First", "Last", "Email", "password", "1234");
    Parent p2 = new Parent("First", "Last", "Email", enc.encryptionService().encode("password"), "1234");
    ResponseEntity OK = new ResponseEntity(HttpStatus.OK);
    ResponseEntity NO = new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
    ResponseEntity CONFLICT = new ResponseEntity(HttpStatus.CONFLICT);
    ResponseEntity UNAUTHORIZED = new ResponseEntity(HttpStatus.UNAUTHORIZED);
    List<Parent> listWithParent = new ArrayList<Parent>() {
        {
            add(p2);
        }
    };
    List<Parent> emptyList = new ArrayList<Parent>();
    @Test
    void getParentInfo() {
        assertTrue(p.getFirst().equals("First"));
        assertTrue(p.getLast().equals("Last"));
        assertTrue(p.getEmail().equals("Email"));
        assertTrue(p.getPassword().equals("password"));
        assertTrue(p.getPhone().equals("1234"));
    }

    @Test
    void getAndSetParentInfo() {
        p.setFirst("f");
        p.setLast("l");
        p.setEmail("e");
        p.setPassword("p");
        p.setPhone("1");
        assertTrue(p.getFirst().equals("f"));
        assertTrue(p.getLast().equals("l"));
        assertTrue(p.getEmail().equals("e"));
        assertTrue(p.getPassword().equals("p"));
        assertTrue(p.getPhone().equals("1"));
    }

    @Test
    void encryptPass() {
        String encPass = enc.encryptionService().encode(p.getPassword());
        assertTrue(enc.encryptionService().matches(p.getPassword(), encPass));
    }

    private ParentService service;

    private ParentRepository repository = Mockito.mock(ParentRepository.class);

    @BeforeEach
    public void init()
    {
        service = new ParentService(repository);
    }

    @Test
    public void testRegisterParent() {
        when(repository.findByEmail(p.getEmail())).thenReturn(emptyList);
        ResponseEntity response = service.addParent(p);
        verify(repository, times(1)).save(p);
        assertTrue(response.equals(OK));
    }

    @Test
    public void testRegisterCollision() {
        when(repository.findByEmail(p.getEmail())).thenReturn(listWithParent);
        ResponseEntity response = service.addParent(p);
        verify(repository, times(1)).findByEmail(p.getEmail());
        assertTrue(response.equals(CONFLICT));
    }

    @Test
    public void testUpdateInfoEmpty() {
        when(repository.findByEmail(p.getEmail())).thenReturn(emptyList);
        ResponseEntity response = service.updateInfo(p);
        verify(repository, times(1)).findByEmail(p.getEmail());
        assertTrue(response.equals(CONFLICT));
    }

    @Test
    public void testUpdateInfo() {
        when(repository.findByEmail(p.getEmail())).thenReturn(listWithParent);
        ResponseEntity response = service.updateInfo(p);
        verify(repository, times(1)).findByEmail(p.getEmail());
        verify(repository, times(1)).save(p);
        assertTrue(response.equals(OK));
    }

    @Test
    public void testLoginInvalidEmail() {
        when(repository.findByEmail(p.getEmail())).thenReturn(emptyList);
        ResponseEntity response = service.loginParent(p);
        verify(repository, times(1)).findByEmail(p.getEmail());
        assertTrue(response.equals(UNAUTHORIZED));
    }

    @Test
    public void testLoginValid() {
        when(repository.findByEmail(p.getEmail())).thenReturn(listWithParent);
        ResponseEntity response = service.loginParent(p);
        verify(repository, times(1)).findByEmail(p.getEmail());
        assertTrue(response.equals(OK));
    }

    @Test
    public void testLoginInvalidPass() {
        p.setPassword("NOTMYPASS");
        when(repository.findByEmail(p.getEmail())).thenReturn(listWithParent);
        ResponseEntity response = service.loginParent(p);
        verify(repository, times(1)).findByEmail(p.getEmail());
        assertTrue(response.equals(UNAUTHORIZED));
    }

}