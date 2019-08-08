package ots.andy.group.horizonsproj.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ots.andy.group.horizonsproj.entities.Daycare;
import ots.andy.group.horizonsproj.entities.Personality;
import ots.andy.group.horizonsproj.repositories.DaycareRepository;
import ots.andy.group.horizonsproj.repositories.PersonalityRepository;

import java.util.List;

@Service
public class PersonalityService {
    private final PersonalityRepository repo;

    @Autowired
    public PersonalityService(PersonalityRepository personalityRepository)
    {
        this.repo = personalityRepository;
    }

    public List<Personality> getAllPersonality(){
        return repo.findAll();
    }
}