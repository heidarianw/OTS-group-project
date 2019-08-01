package ots.andy.group.horizonsproj.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ots.andy.group.horizonsproj.entities.Parent;
import ots.andy.group.horizonsproj.repositories.ParentRepository;

import java.util.List;

@Service
public class ParentService {

    EncryptionService e = new EncryptionService();

    @Autowired
    private ParentRepository parentRepository;

    public boolean addParent(Parent parent) {
        if (!parentRepository.findByEmail(parent.getEmail()).isEmpty()) {
            return false;
        }
        String enc = e.encryptionService().encode(parent.getPassword());
        parent.setPassword(enc);
        System.out.println("Adding parent...");
        parentRepository.save(parent);
        return true;
    }

    public List<Parent> getAllParents(){
        return parentRepository.findAll();
    }

    public int loginParent(Parent parent) {
        if (parentRepository.findByEmail(parent.getEmail()).isEmpty()) {
            return 2;
        }
        String encryptedPass = parentRepository.findByEmail(parent.getEmail()).get(0).getPassword();
        if (e.encryptionService().matches(parent.getPassword(), encryptedPass)) {
            return 0;
        }
        return 1;
    }
}
