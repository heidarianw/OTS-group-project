package ots.andy.group.horizonsproj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ots.andy.group.horizonsproj.entities.Allergy;
import ots.andy.group.horizonsproj.entities.Employee;

@Repository
public interface AllergyRepository extends JpaRepository<Allergy, Integer> {

}