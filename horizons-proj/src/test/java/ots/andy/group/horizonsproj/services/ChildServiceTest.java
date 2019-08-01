package ots.andy.group.horizonsproj.services;

import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ots.andy.group.horizonsproj.entities.Child;

import static org.junit.jupiter.api.Assertions.*;


class ChildServiceTest {

    Child c = new Child("william","heidarian",23,true,true,true,true,true,true,true,"photo");

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
}