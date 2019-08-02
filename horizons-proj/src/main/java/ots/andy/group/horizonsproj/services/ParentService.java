package ots.andy.group.horizonsproj.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity addParent(Parent parent) {
        if (!parentRepository.findByEmail(parent.getEmail()).isEmpty()) {
            return new ResponseEntity( HttpStatus.CONFLICT);
        }
        saveNewInfo(parent);
        return new ResponseEntity(HttpStatus.OK);
    }

    public List<Parent> getAllParents(){
        return parentRepository.findAll();
    }

    public ResponseEntity loginParent(Parent parent) {
        List<Parent> myList = parentRepository.findByEmail(parent.getEmail());
        if (myList.isEmpty()) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
        String encryptedPass = myList.get(0).getPassword();
        if (e.encryptionService().matches(parent.getPassword(), encryptedPass)) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }

    public ResponseEntity updateInfo(Parent parent) {
        List<Parent> myList = parentRepository.findByEmail(parent.getEmail());
        if (myList.isEmpty()) return new ResponseEntity(HttpStatus.CONFLICT);
        int id = myList.get(0).getId();
        parent.setId(id);
        saveNewInfo(parent);
        return new ResponseEntity(HttpStatus.OK);
    }

}
