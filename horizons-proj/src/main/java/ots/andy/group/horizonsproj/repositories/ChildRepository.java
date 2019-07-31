package ots.andy.group.horizonsproj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ots.andy.group.horizonsproj.entities.Child;

import java.util.List;

@Repository
public interface ChildRepository extends JpaRepository<Child, Integer> {

<<<<<<< HEAD
<<<<<<< HEAD
=======
    @Query(value = "SELECT COUNT(*) FROM child WHERE id = ?", nativeQuery = true)
    public long queryCount(int id);

    //public void insertToDB(Child x);
    public long countByFirst(String First);

>>>>>>> b5fbd0437f83f6a34e4ec064f4a163be1117c09b
=======
>>>>>>> parentRegistration
}
