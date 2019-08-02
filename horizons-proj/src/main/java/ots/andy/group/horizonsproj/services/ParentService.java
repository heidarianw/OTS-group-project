package ots.andy.group.horizonsproj.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ots.andy.group.horizonsproj.entities.Parent;
import ots.andy.group.horizonsproj.repositories.ParentRepository;

import java.util.List;

@Service
public class ParentService {

    private final ParentRepository parentRepository;
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

    public boolean loginParent(Parent parent) {
        List<Parent> myList = parentRepository.findByEmail(parent.getEmail());
        if (myList.isEmpty()) {
            return false;
        }
        String encryptedPass = myList.get(0).getPassword();
        if (e.encryptionService().matches(parent.getPassword(), encryptedPass)) {
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
