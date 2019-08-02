package ots.andy.group.horizonsproj.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ots.andy.group.horizonsproj.entities.Child;
import ots.andy.group.horizonsproj.repositories.ChildRepository;

import java.util.List;

@Service
public class ChildService {
    private final ChildRepository childRepository;

    @Autowired
    public ChildService(ChildRepository childRepository)
    {
        this.childRepository = childRepository;
    }

    public ResponseEntity verifyAndRespond(Child child) {
        if(child.getFirst() != null && child.getLast() != null && child.getAge() >= 0){
            childRepository.save(child);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
    }

    public ResponseEntity addChild(Child child) {
        return verifyAndRespond(child);
    }

    public List<Child> getAllChildren() {
        return childRepository.findAll();
    }

    // Must have id in the field!
    public ResponseEntity updateInfo(Child child) {
        if (childRepository.findById(child.getId()).isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return verifyAndRespond(child);
    }
}

