package ots.andy.group.horizonsproj.services;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ots.andy.group.horizonsproj.entities.Child;
import ots.andy.group.horizonsproj.entities.Parent;
import ots.andy.group.horizonsproj.repositories.ParentRepository;

import java.util.Iterator;
import java.util.Set;

@Service
public class ParentService {

    EncryptionService e = new EncryptionService();

    @Autowired
    private ParentRepository parentRepository;


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
        System.out.println("Adding parent...");
        return true;
    }

    public int loginParent(Parent parent) {
        if (parentRepository.findByEmail(parent.getEmail()).isEmpty()) {
            return 2;
        }
        String encryptedPass = parentRepository.findByEmail(parent.getEmail()).get(0).getPassword();
        if (e.encryptionService().matches(parent.getPassword(), encryptedPass)) {
            System.out.println("Logging in parent...");
            return 0;
        }
        return 1;
    }

    public boolean updateInfo(Parent parent) {
        if (parentRepository.findByEmail(parent.getEmail()).isEmpty()) return false;
        int id = parentRepository.findByEmail(parent.getEmail()).get(0).getId();
        parent.setId(id);
        saveNewInfo(parent);
        System.out.println("Updating parent info...");
        return true;
    }

}
