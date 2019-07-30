package ots.andy.group.horizonsproj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ots.andy.group.horizonsproj.entities.Parent;
import ots.andy.group.horizonsproj.repositories.ParentRepository;

import java.util.List;

@SpringBootApplication
public class HorizonsProjApplication implements CommandLineRunner {

	@Autowired
	private ParentRepository parentRepository;

	public static void main(String[] args) {
		SpringApplication.run(HorizonsProjApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		List<Parent> list = parentRepository.findAll();
		for (Parent a : list){
			System.out.println(a.toString());
		}
	}

}
