package ots.andy.group.horizonsproj.services;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ots.andy.group.horizonsproj.entities.Daycare;
import ots.andy.group.horizonsproj.repositories.DaycareRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class DaycareServiceTest {

    private DaycareService service;

    private DaycareRepository repository = Mockito.mock(DaycareRepository.class);
    Daycare d = new Daycare ("Denver");
    List<Daycare> list = new ArrayList<Daycare>() {
        {
            add(d);
        }
    };

    @BeforeEach
    public void init()
    {
        service = new DaycareService(repository);
    }

    @Test
    public void listAll() {
        when(repository.findAll()).thenReturn(list);
        List<Daycare> response = service.getAllDaycare();
        verify(repository, times(1)).findAll();
        assertTrue(list == response);
    }

    @Test
    public void testGetterSetter() {
        Daycare temp = new Daycare();
        temp.setId(2);
        assertTrue(temp.getId() == 2);
        temp.setDaycare("Denver");
        assertTrue(temp.getDaycare() == "Denver");
    }
}
