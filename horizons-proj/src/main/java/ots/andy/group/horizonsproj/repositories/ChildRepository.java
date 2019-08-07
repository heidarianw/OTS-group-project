package ots.andy.group.horizonsproj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ots.andy.group.horizonsproj.entities.Child;

import java.util.BitSet;
import java.util.List;

@Repository
public interface ChildRepository extends JpaRepository<Child, Integer> {


    List<Child> findByFirstIgnoreCase(String first);
    List<Child> findByLastIgnoreCase(String last);
    List<Child> findById(int id);

    void deleteByFirst(String first);
}
