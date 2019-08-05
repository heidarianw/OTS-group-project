package ots.andy.group.horizonsproj.services;

import org.springframework.beans.factory.annotation.Autowired;
import ots.andy.group.horizonsproj.entities.Status;
import ots.andy.group.horizonsproj.repositories.StatusRepository;

import java.util.List;

public class StatusService {

    @Autowired
    private StatusRepository repo;

    public List<Status> getAllStatus(){
        return repo.findAll();
    }
}
