package ots.andy.group.horizonsproj.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ots.andy.group.horizonsproj.entities.Parent;
import ots.andy.group.horizonsproj.repositories.ParentRepository;

@Service
public class ParentService {

    @Autowired
    private ParentRepository parentRepository;

    public void addParent(Parent parent){
        System.out.println(parentRepository.findByEmail(parent.getEmail()));
        if (parentRepository.findByEmail(parent.getEmail()).isEmpty()) {
            System.out.println("Adding parent...");
            parentRepository.save(parent);
        }
        else {
            System.out.println("Email already in use... \n");
        }
    }

}
