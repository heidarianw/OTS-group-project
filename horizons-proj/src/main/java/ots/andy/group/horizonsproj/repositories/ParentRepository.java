package ots.andy.group.horizonsproj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ots.andy.group.horizonsproj.entities.Parent;

import java.util.List;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Integer> {

    List<Parent> findByEmail(String email);


}
