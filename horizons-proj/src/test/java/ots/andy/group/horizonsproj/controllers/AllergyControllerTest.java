package ots.andy.group.horizonsproj.controllers;

import org.apache.coyote.Response;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ots.andy.group.horizonsproj.controllers.AllergyController;
import ots.andy.group.horizonsproj.entities.Allergy;
import ots.andy.group.horizonsproj.entities.Daycare;
import ots.andy.group.horizonsproj.repositories.AllergyRepository;
import ots.andy.group.horizonsproj.repositories.DaycareRepository;
import ots.andy.group.horizonsproj.services.AllergyService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class AllergyControllerTest {

    private AllergyController controller;

    private AllergyService service = Mockito.mock(AllergyService.class);
    Allergy a = new Allergy ("Denver");
    List<Allergy> list = new ArrayList<Allergy>() {
        {
            add(a);
        }
    };

    @BeforeEach public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeEach
    public void init()
    {
        controller = new AllergyController(service);
    }

    @Test
    public void responseTest() {
        when(service.getAllAllergy()).thenReturn(list);
        ResponseEntity<Allergy> response = controller.getAllAllergy();
        verify(service, times(1)).getAllAllergy();
        ResponseEntity<Allergy> out = new ResponseEntity(list, HttpStatus.OK);
        assertTrue(out.equals( response));
    }
}
