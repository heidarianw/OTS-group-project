package ots.andy.group.horizonsproj.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ots.andy.group.horizonsproj.entities.Child;
import ots.andy.group.horizonsproj.repositories.ChildRepository;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChildService {
    private final ChildRepository childRepository;

    @Autowired
    public ChildService(ChildRepository childRepository)
    {
        this.childRepository = childRepository;
    }

    public boolean verifyAndRespond(Child child) {
        if(child.getFirst() != null && child.getLast() != null && child.getAge() >= 0){
            return true;
        }
        return false;
    }

    public Child addChild(Child child) throws Exception{
        if (verifyAndRespond(child)) {
            return childRepository.save(child);
        } else throw new Exception("Child not saved");
    }

    public List<Child> getAllChildren() {
        return childRepository.findAll();
    }

    // Must have id in the field!
    public Child updateInfo(Child child) throws Exception {
        if (childRepository.findById(child.getId()).isEmpty()) {
            throw new Exception("Child does not exist");
        }
        if (verifyAndRespond(child)) {
            return childRepository.save(child);
        } else throw new Exception("Child not updated");
    }

    public Child findById(int id) throws Exception{
        List<Child> result = childRepository.findById(id);
        if (!result.isEmpty()){
            return result.get(0);
        } else throw new Exception("Cannot find ID.");
    }

    public List<Child> getSearchedChildren(String term){
        List<Child> completeList = new ArrayList<>();
        if(term.indexOf(" ") == -1){
            completeList.addAll(childRepository.findByFirstIgnoreCase(term));
            completeList.addAll(childRepository.findByLastIgnoreCase(term));
        }
        else{
            String[] terms = term.split(" ");
            completeList.addAll(childRepository.findByFirstIgnoreCase(terms[0]));
            completeList.addAll(childRepository.findByLastIgnoreCase(terms[1]));
        }
        return completeList;
    }
}

