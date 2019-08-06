package ots.andy.group.horizonsproj.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ots.andy.group.horizonsproj.entities.Child;
import ots.andy.group.horizonsproj.repositories.ChildRepository;

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
            childRepository.save(child);
            return true;
        }
        return false;
    }

    public boolean addChild(Child child) {
        return verifyAndRespond(child);
    }

    public List<Child> getAllChildren() {
        return childRepository.findAll();
    }

    // Must have id in the field!
    public boolean updateInfo(Child child) {
        if (childRepository.findById(child.getId()).isEmpty()) {
            return false;
        }
        return verifyAndRespond(child);
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
            completeList.addAll(childRepository.findByFirst(term));
            completeList.addAll(childRepository.findByLast(term));
        }
        else{
            String[] terms = term.split(" ");
            completeList.addAll(childRepository.findByFirst(terms[0]));
            completeList.addAll(childRepository.findByLast(terms[1]));
        }
        return completeList;
    }
}

