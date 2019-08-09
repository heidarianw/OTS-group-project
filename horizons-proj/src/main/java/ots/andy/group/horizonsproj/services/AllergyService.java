package ots.andy.group.horizonsproj.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ots.andy.group.horizonsproj.entities.Allergy;
import ots.andy.group.horizonsproj.entities.Status;
import ots.andy.group.horizonsproj.repositories.AllergyRepository;
import ots.andy.group.horizonsproj.repositories.StatusRepository;

import java.util.List;

@Service
public class AllergyService {

    private final AllergyRepository repo;
    @Autowired
    public AllergyService(AllergyRepository allergyRepository)
    {
        this.repo = allergyRepository;
    }

    public List<Allergy> getAllAllergy(){
        return repo.findAll();
    }
}
