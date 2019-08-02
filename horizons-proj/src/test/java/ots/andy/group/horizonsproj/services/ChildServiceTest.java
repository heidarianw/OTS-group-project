package ots.andy.group.horizonsproj.services;

import org.apache.coyote.Response;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ots.andy.group.horizonsproj.entities.Child;
import ots.andy.group.horizonsproj.repositories.ChildRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ChildServiceTest {

    Child c = new Child("william", "heidarian", 23, true, true, true, true, true, true, true, "photo");
    ResponseEntity OK = new ResponseEntity(HttpStatus.OK);
    ResponseEntity NO = new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
    List<Child> listWithChild = new ArrayList<Child>() {
        {
            add(c);
        }
    };

    @Test
    void getChildInfo() {
        assertTrue(c.getFirst().equals("william"));
        assertTrue(c.getLast().equals("heidarian"));
        assertTrue(c.getAge() == 23);
        assertTrue(c.isSunday() == true);
        assertTrue(c.isSaturday() == true);
        assertTrue(c.isMonday() == true);
        assertTrue(c.isTuesday() == true);
        assertTrue(c.isWednesday() == true);
        assertTrue(c.isThursday() == true);
        assertTrue(c.isFriday() == true);
        assertTrue(c.getPhoto().equals("photo"));
    }

    @Test
    void getAndSetChildInfo() {
        c.setFirst("will");
        c.setLast("hei");
        c.setAge(24);
        c.setSunday(false);
        c.setMonday(false);
        c.setTuesday(false);
        c.setWednesday(false);
        c.setThursday(false);
        c.setFriday(false);
        c.setSaturday(false);
        c.setPhoto("photo2");
        assertTrue(c.getFirst().equals("will"));
        assertTrue(c.getLast().equals("hei"));
        assertTrue(c.getAge() == 24);
        assertTrue(c.isSunday() == false);
        assertTrue(c.isSaturday() == false);
        assertTrue(c.isMonday() == false);
        assertTrue(c.isTuesday() == false);
        assertTrue(c.isWednesday() == false);
        assertTrue(c.isThursday() == false);
        assertTrue(c.isFriday() == false);
        assertTrue(c.getPhoto().equals("photo2"));
    }

    private ChildService service;

    private ChildRepository repository = Mockito.mock(ChildRepository.class);

    @BeforeEach
    public void init()
    {
        service = new ChildService(repository);
    }

    @Test
    public void testAddChild() {
        ResponseEntity response = service.addChild(c);
        verify(repository, times(1)).save(c);
        assertTrue(response.equals(OK));
    }

    @Test
    public void testAddBadAge() {
        c.setAge(-1);
        ResponseEntity response = service.addChild(c);
        verify(repository, times(0)).save(c);
        assertTrue(response.equals(NO));
        c.setAge(10);
    }

    @Test
    public void testAddNullFirst() {
        c.setFirst(null);
        ResponseEntity response = service.addChild(c);
        verify(repository, times(0)).save(c);
        assertTrue(response.equals(NO));
        c.setFirst("test");
    }

    @Test
    public void testAddNullLast() {
        c.setLast(null);
        ResponseEntity response = service.addChild(c);
        verify(repository, times(0)).save(c);
        assertTrue(response.equals(NO));
        c.setLast("last");
    }

    @Test
    public void testUpdateChild() {
        when(repository.findById(c.getId())).thenReturn(listWithChild);
        ResponseEntity response = service.updateInfo(c);
        verify(repository, times(1)).findById(c.getId());
        verify(repository, times(1)).save(c);
        assertTrue(response.equals(OK));
    }

    @Test
    public void testUpdateChildBadAge() {
        c.setAge(-1);
        when(repository.findById(c.getId())).thenReturn(listWithChild);
        ResponseEntity response = service.updateInfo(c);
        verify(repository, times(1)).findById(c.getId());
        verify(repository, times(0)).save(c);
        assertTrue(response.equals(NO));
        c.setAge(10);
    }
}