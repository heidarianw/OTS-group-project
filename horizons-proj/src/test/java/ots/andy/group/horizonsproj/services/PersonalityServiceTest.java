package ots.andy.group.horizonsproj.services;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ots.andy.group.horizonsproj.entities.Allergy;
import ots.andy.group.horizonsproj.entities.Daycare;
import ots.andy.group.horizonsproj.entities.Personality;
import ots.andy.group.horizonsproj.repositories.AllergyRepository;
import ots.andy.group.horizonsproj.repositories.DaycareRepository;
import ots.andy.group.horizonsproj.repositories.PersonalityRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class PersonalityServiceTest {

    private PersonalityService service;

    private PersonalityRepository repository = Mockito.mock(PersonalityRepository.class);
    Personality p = new Personality ("Denver");
    List<Personality> list = new ArrayList<Personality>() {
        {
            add(p);
        }
    };

    @BeforeEach
    public void init()
    {
        service = new PersonalityService(repository);
    }

    @Test
    public void listAll() {
        when(repository.findAll()).thenReturn(list);
        List<Personality> response = service.getAllPersonality();
        verify(repository, times(1)).findAll();
        assertTrue(list == response);
    }

    @Test
    public void testGetterSetter() {
        Personality temp = new Personality();
        temp.setId(2);
        assertTrue(temp.getId() == 2);
        temp.setPersonality("Fun-Loving");
        assertTrue(temp.getPersonality() == "Fun-Loving");
    }
}
