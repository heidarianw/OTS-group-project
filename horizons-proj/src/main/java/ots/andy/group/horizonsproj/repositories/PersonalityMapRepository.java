package ots.andy.group.horizonsproj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ots.andy.group.horizonsproj.entities.Employee;
import ots.andy.group.horizonsproj.entities.PersonalityMap;

@Repository
public interface PersonalityMapRepository extends JpaRepository<PersonalityMap, Integer> {

}