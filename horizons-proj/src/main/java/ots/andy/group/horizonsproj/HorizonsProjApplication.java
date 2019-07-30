package ots.andy.group.horizonsproj;

import ch.qos.logback.core.CoreConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ots.andy.group.horizonsproj.entities.Allergy;
import ots.andy.group.horizonsproj.entities.AllergyMap;
import ots.andy.group.horizonsproj.entities.Child;
import ots.andy.group.horizonsproj.repositories.AllergyMapRepository;
import ots.andy.group.horizonsproj.repositories.ChildRepository;

@SpringBootApplication
public class HorizonsProjApplication implements CommandLineRunner {

	@Autowired
	private ChildRepository repo;
	@Autowired
	private AllergyMapRepository allergyMapRepo;

	public static void main(String[] args) {
		SpringApplication.run(HorizonsProjApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		Child x = new Child("clay", "k", 22, false, false, false, false, false, false, false, 1, "url");
		repo.save(x);
		AllergyMap a1 = new AllergyMap(x.getId(), 5);
		allergyMapRepo.save(a1);
	}

}
