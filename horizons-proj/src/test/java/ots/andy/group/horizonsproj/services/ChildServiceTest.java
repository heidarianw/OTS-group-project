package ots.andy.group.horizonsproj.services;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ots.andy.group.horizonsproj.entities.Child;
import ots.andy.group.horizonsproj.repositories.ChildRepository;
import ots.andy.group.horizonsproj.services.ChildService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ChildServiceTest {

    Child c = new Child("william", "heidarian", 23, true, true, true, true, true, true, true, "photo");
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
        Child temp = new Child();
        temp.setFirst("will");
        temp.setLast("hei");
        temp.setAge(24);
        temp.setSunday(false);
        temp.setMonday(false);
        temp.setTuesday(false);
        temp.setWednesday(false);
        temp.setThursday(false);
        temp.setFriday(false);
        temp.setSaturday(false);
        temp.setPhoto("photo2");
        assertTrue(temp.getFirst().equals("will"));
        assertTrue(temp.getLast().equals("hei"));
        assertTrue(temp.getAge() == 24);
        assertTrue(temp.isSunday() == false);
        assertTrue(temp.isSaturday() == false);
        assertTrue(temp.isMonday() == false);
        assertTrue(temp.isTuesday() == false);
        assertTrue(temp.isWednesday() == false);
        assertTrue(temp.isThursday() == false);
        assertTrue(temp.isFriday() == false);
        assertTrue(temp.getPhoto().equals("photo2"));
    }

    private ChildService service;

    private ChildRepository repository = Mockito.mock(ChildRepository.class);

    @BeforeEach
    public void init()
    {
        service = new ChildService(repository);
    }

    @Test
    public void AddChild() throws Exception {
        Child response = service.addChild(c);
        verify(repository, times(1)).save(c);
    }

    @Test
    public void testAddBadAge() throws Exception {
        boolean ex = false;
        try {
            c.setAge(-1);
            Child response = service.addChild(c);
            verify(repository, times(0)).save(c);
            c.setAge(10);
        } catch(Exception e) {
            ex = true;
        }
        assertTrue(ex);
    }

    @Test
    public void testAddNullFirst() throws Exception {
        boolean ex = false;
        try {
            c.setFirst(null);
            Child response = service.addChild(c);
            verify(repository, times(0)).save(c);
            c.setFirst("test");
        } catch(Exception e) {
            ex = true;
        }
        assertTrue(ex);
    }

    @Test
    public void testAddNullLast() throws Exception {
        boolean ex = false;
        try {
            c.setLast(null);
            Child response = service.addChild(c);
            verify(repository, times(0)).save(c);
            c.setLast("last");
        } catch(Exception e) {
            ex = true;
        }
        assertTrue(ex);
    }

    @Test
    public void testUpdateChild() throws Exception {
        boolean ex = false;
        try {
            when(repository.findById(c.getId())).thenReturn(listWithChild);
            Child response = service.updateInfo(c);
            verify(repository, times(1)).findById(c.getId());
            verify(repository, times(1)).save(c);
        } catch(Exception e) {

        }
        assertFalse(ex);
    }

    @Test
    public void testUpdateChildBadAge() throws Exception {
        boolean ex = false;
        try {
            c.setAge(-1);
            when(repository.findById(c.getId())).thenReturn(listWithChild);
            Child response = service.updateInfo(c);
            verify(repository, times(1)).findById(c.getId());
            verify(repository, times(0)).save(c);
            c.setAge(10);
        } catch(Exception e) {
            ex = true;
        }
        assertTrue(ex);
    }
}