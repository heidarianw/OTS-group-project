package ots.andy.group.horizonsproj;

import ch.qos.logback.core.CoreConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.Query;
import ots.andy.group.horizonsproj.entities.Allergy;
import ots.andy.group.horizonsproj.entities.Child;
import ots.andy.group.horizonsproj.repositories.ChildRepository;

@SpringBootApplication
public class HorizonsProjApplication implements CommandLineRunner {

	@Autowired
	private ChildRepository repo;


	public static void main(String[] args) {
		SpringApplication.run(HorizonsProjApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
//		Child x = new Child("clay", "k", 22, false, false, false, false, false, false, false, 1, "url");
//		Allergy a = new Allergy("Peanut");
//		x.addAllergy(a);
//		repo.save(x);
		//System.out.println(repo.queryCount(3));
		//System.out.println(repo.countByFirst(x.getFirst()));
	}
}
