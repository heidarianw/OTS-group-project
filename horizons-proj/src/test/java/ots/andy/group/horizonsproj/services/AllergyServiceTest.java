package ots.andy.group.horizonsproj.services;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ots.andy.group.horizonsproj.entities.Allergy;
import ots.andy.group.horizonsproj.entities.Daycare;
import ots.andy.group.horizonsproj.repositories.AllergyRepository;
import ots.andy.group.horizonsproj.repositories.DaycareRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class AllergyServiceTest {

    private AllergyService service;

    private AllergyRepository repository = Mockito.mock(AllergyRepository.class);
    Allergy a = new Allergy ("Denver");
    List<Allergy> list = new ArrayList<Allergy>() {
        {
            add(a);
        }
    };

    @BeforeEach
    public void init()
    {
        service = new AllergyService(repository);
    }

    @Test
    public void listAll() {
        when(repository.findAll()).thenReturn(list);
        List<Allergy> response = service.getAllAllergy();
        verify(repository, times(1)).findAll();
        assertTrue(list == response);
    }

    @Test
    public void testGetterSetter() {
        Allergy temp = new Allergy();
        temp.setId(2);
        assertTrue(temp.getId() == 2);
        temp.setAllergy("Peanut");
        assertTrue(temp.getAllergy() == "Peanut");
    }
}
