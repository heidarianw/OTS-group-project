package ots.andy.group.horizonsproj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ots.andy.group.horizonsproj.entities.Child;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import ots.andy.group.horizonsproj.services.ChildService;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class ChildController {

    @Autowired
    private ChildService childService;

    @GetMapping(path="/children", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Child> getAllParents(){
        return childService.getAllChildren();
    }

    @PostMapping("/child")
    public ResponseEntity<Child> addChild(@RequestBody Child child) {
        try {
            return new ResponseEntity(childService.addChild(child), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping("/child")
    public ResponseEntity<Child> updateInfo(@RequestBody Child child) {
        if (childService.updateInfo(child)) return new ResponseEntity(child, HttpStatus.OK);
        return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping("/child/{id}")
    public ResponseEntity<Child> searchChild(@PathVariable int id){
        try {
            return new ResponseEntity(childService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
