package ots.andy.group.horizonsproj.services;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ots.andy.group.horizonsproj.entities.Status;
import ots.andy.group.horizonsproj.repositories.StatusRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class StatusServiceTest {

    private StatusService service;

    private StatusRepository repository = Mockito.mock(StatusRepository.class);
    Status s = new Status ("Active");
    List<Status> list = new ArrayList<Status>() {
        {
            add(s);
        }
    };

    @BeforeEach
    public void init()
    {
        service = new StatusService(repository);
    }

    @Test
    public void listAll() {
        when(repository.findAll()).thenReturn(list);
        List<Status> response = service.getAllStatus();
        verify(repository, times(1)).findAll();
        assertTrue(list == response);
    }

    @Test
    public void testGetterSetter() {
        Status temp = new Status();
        temp.setId(2);
        assertTrue(temp.getId() == 2);
        temp.setStatus("Inactive");
        assertTrue(temp.getStatus() == "Inactive");
    }
}
