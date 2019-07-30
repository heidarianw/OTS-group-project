package ots.andy.group.horizonsproj.controllers;

import org.springframework.web.bind.annotation.RestController;
import ots.andy.group.horizonsproj.entities.Child;
import ots.andy.group.horizonsproj.repositories.ChildRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
public class ChildController {

    private final ChildRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    ChildController(ChildRepository repository) { this.repository = repository; }

    List<Child> findAll() {
        return repository.findAll();
    }

   // void insertToDB(Child child){
//        entityManager.createNativeQuery("INSERT INTO child VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?")
//                .setParameter(1, "default")
//                .setParameter(2, child.getFirst())
//                .setParameter(3, child.getLast())
//                .setParameter(4, child.getAge())
//                .setParameter(5, false)
//                .setParameter(6, false)
//                .setParameter(7, false)
//                .setParameter(8, false)
//                .setParameter(9, false)
//                .setParameter(10, false)
//                .setParameter(11, false)
//                .setParameter(12, child.getStatus())
//                .setParameter(13, "photo.url")
//                .executeUpdate();
//        for(Child a : repository.findAll()){
//            System.out.println(a.toString());
//        }
   //}


}
