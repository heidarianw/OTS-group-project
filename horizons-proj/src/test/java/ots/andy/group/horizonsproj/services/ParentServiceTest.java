package ots.andy.group.horizonsproj.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
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
        Parent temp = new Parent();
        temp.setFirst("f");
        temp.setLast("l");
        temp.setEmail("e");
        temp.setPassword("p");
        temp.setPhone("1");
        assertTrue(temp.getFirst().equals("f"));
        assertTrue(temp.getLast().equals("l"));
        assertTrue(temp.getEmail().equals("e"));
        assertTrue(temp.getPassword().equals("p"));
        assertTrue(temp.getPhone().equals("1"));
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
        boolean response = service.addParent(p);
        verify(repository, times(1)).save(p);
        assertTrue(response);
    }

    @Test
    public void testRegisterCollision() {
        when(repository.findByEmail(p.getEmail())).thenReturn(listWithParent);
        boolean response = service.addParent(p);
        verify(repository, times(1)).findByEmail(p.getEmail());
        assertFalse(response);
    }

    @Test
    public void testUpdateInfoEmpty() {
        when(repository.findByEmail(p.getEmail())).thenReturn(emptyList);
        boolean response = service.updateInfo(p);
        verify(repository, times(1)).findByEmail(p.getEmail());
        assertFalse(response);
    }

    @Test
    public void testUpdateInfo() {
        when(repository.findByEmail(p.getEmail())).thenReturn(listWithParent);
        boolean response = service.updateInfo(p);
        verify(repository, times(1)).findByEmail(p.getEmail());
        verify(repository, times(1)).save(p);
        assertTrue(response);
    }

    @Test
    public void testLoginInvalidEmail() {
        when(repository.findByEmail(p.getEmail())).thenReturn(emptyList);
        boolean response = service.loginParent(p);
        verify(repository, times(1)).findByEmail(p.getEmail());
        assertFalse(response);
    }

    @Test
    public void testLoginValid() {
        when(repository.findByEmail(p.getEmail())).thenReturn(listWithParent);
        boolean response = service.loginParent(p);
        verify(repository, times(1)).findByEmail(p.getEmail());
        assertTrue(response );
    }

    @Test
    public void testLoginInvalidPass() {
        p.setPassword("NOTMYPASS");
        when(repository.findByEmail(p.getEmail())).thenReturn(listWithParent);
        boolean response = service.loginParent(p);
        verify(repository, times(1)).findByEmail(p.getEmail());
        assertFalse(response);
    }

}