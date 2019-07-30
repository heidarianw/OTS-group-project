package ots.andy.group.horizonsproj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ots.andy.group.horizonsproj.entities.Child;

@Repository
public interface ChildRepository extends JpaRepository<Child, Integer> {

    //public void insertToDB(Child x);

}
