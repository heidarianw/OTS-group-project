package ots.andy.group.horizonsproj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ots.andy.group.horizonsproj.entities.Child;
import ots.andy.group.horizonsproj.services.ChildService;

@RestController
public class ChildController {

    @Autowired
    private ChildService childService;

    @PostMapping("/child")
    public ResponseEntity addChild(@RequestBody Child child) {
        return childService.addChild(child);
    }

    @PutMapping("/child")
    public ResponseEntity updateInfo(@RequestBody Child child) {
        return childService.updateInfo(child);
    }
}
