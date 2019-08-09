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
import ots.andy.group.horizonsproj.controllers.DaycareController;
import ots.andy.group.horizonsproj.entities.Allergy;
import ots.andy.group.horizonsproj.entities.Daycare;
import ots.andy.group.horizonsproj.repositories.AllergyRepository;
import ots.andy.group.horizonsproj.repositories.DaycareRepository;
import ots.andy.group.horizonsproj.services.DaycareService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class DaycareControllerTest {

    private DaycareController controller;

    private DaycareService service = Mockito.mock(DaycareService.class);
    Daycare d = new Daycare ("Denver");
    List<Daycare> list = new ArrayList<Daycare>() {
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
        controller = new DaycareController(service);
    }

    @Test
    public void responseTest() {
        when(service.getAllDaycare()).thenReturn(list);
        ResponseEntity<Daycare> response = controller.getAllDaycare();
        verify(service, times(1)).getAllDaycare();
        ResponseEntity<Daycare> out = new ResponseEntity(list, HttpStatus.OK);
        assertTrue(out.equals( response));
    }
}
