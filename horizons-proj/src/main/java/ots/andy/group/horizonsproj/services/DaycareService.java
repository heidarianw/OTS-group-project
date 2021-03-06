package ots.andy.group.horizonsproj.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ots.andy.group.horizonsproj.entities.Daycare;
import ots.andy.group.horizonsproj.repositories.DaycareRepository;

import java.util.List;

@Service
public class DaycareService {
    private final DaycareRepository repo;
    @Autowired
    public DaycareService(DaycareRepository daycareRepository)
    {
        this.repo = daycareRepository;
    }

    public List<Daycare> getAllDaycare(){
        return repo.findAll();
    }
}