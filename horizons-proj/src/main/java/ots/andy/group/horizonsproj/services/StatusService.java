package ots.andy.group.horizonsproj.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ots.andy.group.horizonsproj.entities.Status;
import ots.andy.group.horizonsproj.repositories.StatusRepository;

import java.util.List;

@Service
public class StatusService {
    private final StatusRepository repo;

    @Autowired
    public StatusService(StatusRepository statusRepository)
    {
        this.repo = statusRepository;
    }

    public List<Status> getAllStatus(){
        return repo.findAll();
    }
}
