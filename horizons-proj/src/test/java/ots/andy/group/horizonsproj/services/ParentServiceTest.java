package ots.andy.group.horizonsproj.services;

import org.junit.jupiter.api.Test;
import ots.andy.group.horizonsproj.entities.Parent;

import static org.junit.jupiter.api.Assertions.*;

class ParentServiceTest {

    Parent p = new Parent("First", "Last", "Email", "password", "1234");

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
        EncryptionService encryptionService = new EncryptionService();
        String enc = encryptionService.encryptionService().encode(p.getPassword());
        assertTrue(encryptionService.encryptionService().matches(p.getPassword(), enc));
    }

}