package ots.andy.group.horizonsproj;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HorizonsProjApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HorizonsProjApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("Ready");
	}
}
