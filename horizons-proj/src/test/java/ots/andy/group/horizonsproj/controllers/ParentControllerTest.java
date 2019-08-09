package ots.andy.group.horizonsproj.controllers;

import org.apache.coyote.Response;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import ots.andy.group.horizonsproj.controllers.*;
import ots.andy.group.horizonsproj.entities.*;
import ots.andy.group.horizonsproj.repositories.AllergyRepository;
import ots.andy.group.horizonsproj.repositories.DaycareRepository;
import ots.andy.group.horizonsproj.repositories.ParentRepository;
import ots.andy.group.horizonsproj.services.ParentService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class ParentControllerTest {

    private ParentController controller;

    private ParentService service = Mockito.mock(ParentService.class);
    private ParentRepository repo = Mockito.mock(ParentRepository.class);
    Parent d = new Parent ("a", "b", "c", "d", "e");
    List<Parent> list = new ArrayList<Parent>() {
        {
            add(d);
        }
    };

    Set<Parent> set = new HashSet<Parent>() {
        {
            add(d);
        }
    };

    @BeforeEach public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeEach
    public void init()
    {
        controller = new ParentController(service, repo);
    }

    @Test
    public void getAllTest() {
        when(service.getAllParents()).thenReturn(list);
        List<Parent> response = controller.getAllParents();
        verify(service, times(1)).getAllParents();
        ResponseEntity<Status> out = new ResponseEntity(list, HttpStatus.OK);
        assertTrue(list.equals( response));
    }

    @Test
    public void testCreateParent() {
        ResponseEntity<Parent> resp = new ResponseEntity(d, HttpStatus.OK);
        when(service.addParent(any(Parent.class))).thenReturn(true);
        ResponseEntity<Parent> out = controller.createParent(d);
        verify(service, times(1)).addParent(d);
        assertTrue(resp.equals(out));
    }

    @Test
    public void testLoginParent() {
        ResponseEntity<Parent> resp = new ResponseEntity(d, HttpStatus.OK);
        when(service.loginParent(any(Parent.class))).thenReturn(true);
        ResponseEntity<Parent> out = controller.loginParent(d);
        verify(service, times(1)).loginParent(d);
        assertTrue(resp.equals(out));
    }

    @Test
    public void testGetParentofChild() {
        when(service.getParentsOfChild(1)).thenReturn(set);
        ResponseEntity<Parent> resp = new ResponseEntity(set, HttpStatus.OK);
        ResponseEntity<Parent> out = controller.getParentsOfChild(1);
        verify(service, times(1)).getParentsOfChild(1);
        assertTrue(resp.equals(out));
    }

    @Test
    public void testUpdateInfo() {
        ResponseEntity<Parent> resp = new ResponseEntity(d, HttpStatus.OK);
        when(service.updateInfo(any(Parent.class))).thenReturn(true);
        ResponseEntity<Parent> out = controller.updateInfo(d);
        verify(service, times(1)).updateInfo(d);
        assertTrue(resp.equals(out));
    }

}
