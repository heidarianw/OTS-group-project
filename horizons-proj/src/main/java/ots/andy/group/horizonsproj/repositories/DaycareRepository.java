package ots.andy.group.horizonsproj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ots.andy.group.horizonsproj.entities.Daycare;
import ots.andy.group.horizonsproj.entities.Employee;

@Repository
public interface DaycareRepository extends JpaRepository<Daycare, Integer> {

}