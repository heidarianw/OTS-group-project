package ots.andy.group.horizonsproj.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ots.andy.group.horizonsproj.entities.Child;
import ots.andy.group.horizonsproj.entities.Parent;
import ots.andy.group.horizonsproj.entities.Status;
import ots.andy.group.horizonsproj.services.ChildService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class ChildControllerTest {

    private ChildController controller;

    private ChildService service = Mockito.mock(ChildService.class);

    Child c = new Child("william", "heidarian", 23, true, true, true, true, true, true, true, "photo");
    List<Child> list = new ArrayList<Child>() {
        {
            add(c);
        }
    };
    @BeforeEach
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeEach
    public void init()
    {
        controller = new ChildController(service);
    }

    @Test
    public void getChildren() {
        when(service.getAllChildren()).thenReturn(list);
        List<Child> response = controller.getAllParents();
        verify(service, times(1)).getAllChildren();
        ResponseEntity<Status> out = new ResponseEntity(list, HttpStatus.OK);
        assertTrue(list.equals( response));
    }

    @Test
    public void testAddChild() throws Exception {
        ResponseEntity<Child> resp = new ResponseEntity(c, HttpStatus.OK);
        when(service.addChild(any(Child.class))).thenReturn(c);
        ResponseEntity<Child> out = controller.addChild(c);
        verify(service, times(1)).addChild(c);
        assertTrue(resp.equals(out));
    }

    @Test
    public void testUpdateInfo() throws Exception {
        ResponseEntity<Child> resp = new ResponseEntity(c, HttpStatus.OK);
        when(service.updateInfo(any(Child.class))).thenReturn(c);
        ResponseEntity<Child> out = controller.updateInfo(c);
        verify(service, times(1)).updateInfo(c);
        assertTrue(resp.equals(out));
    }


}
