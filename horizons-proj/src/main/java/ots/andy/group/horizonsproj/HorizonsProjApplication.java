package ots.andy.group.horizonsproj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
		Child x = new Child("lena", "wayson", 21, false, false, false, false, false, false, false, 1, "url");
		repo.save(x);
	}

}
