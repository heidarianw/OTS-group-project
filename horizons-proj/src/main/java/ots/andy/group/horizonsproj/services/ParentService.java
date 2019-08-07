package ots.andy.group.horizonsproj.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ots.andy.group.horizonsproj.entities.Child;
import ots.andy.group.horizonsproj.entities.Parent;
import ots.andy.group.horizonsproj.repositories.ChildRepository;
import ots.andy.group.horizonsproj.repositories.ParentRepository;

import java.util.List;
import java.util.Set;

@Service
public class ParentService {

    private final ParentRepository parentRepository;

    @Autowired
    private ChildRepository childRepository;

    EncryptionService e = new EncryptionService();

    @Autowired
    public ParentService(ParentRepository parentRepository)
    {
        this.parentRepository = parentRepository;
    }

    public void saveNewInfo(Parent parent) {
        String enc = e.encryptionService().encode(parent.getPassword());
        parent.setPassword(enc);
        parentRepository.save(parent);
    }

    public boolean addParent(Parent parent) {
        if (!parentRepository.findByEmail(parent.getEmail()).isEmpty()) {
            return false;
        }
        saveNewInfo(parent);
        return true;
    }

    public List<Parent> getAllParents(){
        return parentRepository.findAll();
    }

    public Set<Parent> getParentsOfChild(int id){
        return childRepository.findById(id).get(0).getParentSet();
    }

    public boolean loginParent(Parent parent) {
        List<Parent> myList = parentRepository.findByEmail(parent.getEmail());
        if (myList.isEmpty()) {
            return false;
        }
        String encryptedPass = myList.get(0).getPassword();
        if (e.encryptionService().matches(parent.getPassword(), encryptedPass)) {
            parent.setId(myList.get(0).getId());
            parent.setFirst(myList.get(0).getFirst());
            parent.setLast(myList.get(0).getLast());
            parent.setPhone(myList.get(0).getPhone());
            parent.setChildren(myList.get(0).getChildren());
            return true;
        }
        return false;
    }

    public boolean updateInfo(Parent parent) {
        List<Parent> myList = parentRepository.findByEmail(parent.getEmail());
        if (myList.isEmpty()) return false;
        int id = myList.get(0).getId();
        parent.setId(id);
        saveNewInfo(parent);
        return true;
    }

}
