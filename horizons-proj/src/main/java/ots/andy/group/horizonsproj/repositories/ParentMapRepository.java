package ots.andy.group.horizonsproj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ots.andy.group.horizonsproj.entities.Employee;
import ots.andy.group.horizonsproj.entities.ParentMap;

@Repository
public interface ParentMapRepository extends JpaRepository<ParentMap, Integer> {

}