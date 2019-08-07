package ots.andy.group.horizonsproj.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ots.andy.group.horizonsproj.entities.Child;
import ots.andy.group.horizonsproj.repositories.ChildRepository;

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
    public void testAddChild() throws Exception {
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