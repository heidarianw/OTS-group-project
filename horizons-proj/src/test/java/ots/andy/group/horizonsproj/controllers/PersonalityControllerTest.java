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
import ots.andy.group.horizonsproj.entities.Allergy;
import ots.andy.group.horizonsproj.entities.Daycare;
import ots.andy.group.horizonsproj.entities.Personality;
import ots.andy.group.horizonsproj.repositories.AllergyRepository;
import ots.andy.group.horizonsproj.repositories.DaycareRepository;
import ots.andy.group.horizonsproj.services.PersonalityService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class PersonalityControllerTest {

    private PersonalityController controller;

    private PersonalityService service = Mockito.mock(PersonalityService.class);
    Personality d = new Personality ("Denver");
    List<Personality> list = new ArrayList<Personality>() {
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
        controller = new PersonalityController(service);
    }

    @Test
    public void responseTest() {
        when(service.getAllPersonality()).thenReturn(list);
        ResponseEntity<Personality> response = controller.getAllPersonality();
        verify(service, times(1)).getAllPersonality();
        ResponseEntity<Personality> out = new ResponseEntity(list, HttpStatus.OK);
        assertTrue(out.equals( response));
    }
}
