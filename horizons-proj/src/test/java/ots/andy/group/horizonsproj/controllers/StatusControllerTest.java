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
import ots.andy.group.horizonsproj.controllers.AllergyController;
import ots.andy.group.horizonsproj.controllers.DaycareController;
import ots.andy.group.horizonsproj.controllers.PersonalityController;
import ots.andy.group.horizonsproj.controllers.StatusController;
import ots.andy.group.horizonsproj.entities.Allergy;
import ots.andy.group.horizonsproj.entities.Daycare;
import ots.andy.group.horizonsproj.entities.Personality;
import ots.andy.group.horizonsproj.entities.Status;
import ots.andy.group.horizonsproj.repositories.AllergyRepository;
import ots.andy.group.horizonsproj.repositories.DaycareRepository;
import ots.andy.group.horizonsproj.services.StatusService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class StatusControllerTest {

    private StatusController controller;

    private StatusService service = Mockito.mock(StatusService.class);
    Status d = new Status ("Denver");
    List<Status> list = new ArrayList<Status>() {
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
        controller = new StatusController(service);
    }

    @Test
    public void responseTest() {
        when(service.getAllStatus()).thenReturn(list);
        ResponseEntity<Status> response = controller.getAllStatus();
        verify(service, times(1)).getAllStatus();
        ResponseEntity<Status> out = new ResponseEntity(list, HttpStatus.OK);
        assertTrue(out.equals( response));
    }
}
