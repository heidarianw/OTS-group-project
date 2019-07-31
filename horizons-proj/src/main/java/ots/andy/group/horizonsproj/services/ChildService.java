package ots.andy.group.horizonsproj.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ots.andy.group.horizonsproj.entities.Allergy;
import ots.andy.group.horizonsproj.entities.Child;
import ots.andy.group.horizonsproj.repositories.ChildRepository;

import java.util.List;

@Service
public class ChildService {
    @Autowired
    private ChildRepository childRepository;

    public ResponseEntity addChild(Child child){
        if(child.getFirst() != null && child.getLast() != null && child.getAge() != 0){
            childRepository.save(child);
            return new ResponseEntity(HttpStatus.OK);
        }
        else {
            return new ResponseEntity("The else", HttpStatus.OK);
        }
    }
}
