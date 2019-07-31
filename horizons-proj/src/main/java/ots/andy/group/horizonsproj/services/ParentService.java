package ots.andy.group.horizonsproj.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ots.andy.group.horizonsproj.entities.Parent;
import ots.andy.group.horizonsproj.repositories.ParentRepository;

@Service
public class ParentService {

    @Autowired
    private ParentRepository parentRepository;

    public boolean addParent(Parent parent){
        if (!parentRepository.findByEmail(parent.getEmail()).isEmpty()) {
            return false;
        }
        else {
            System.out.println("Adding parent...");
            parentRepository.save(parent);
            return true;
        }
    }

    public String getAllParents(){
        return parentRepository.findAll().toString();
    }

}
