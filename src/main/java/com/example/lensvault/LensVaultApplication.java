package com.example.lensvault;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.lensvault.model.Lens;
import com.example.lensvault.model.LensRepository;
import com.example.lensvault.model.Mount;
import com.example.lensvault.model.MountRepository;
import com.example.lensvault.model.PrimeOrZoom;
import com.example.lensvault.model.PrimeOrZoomRepository;
import com.example.lensvault.model.User;
import com.example.lensvault.model.UserRepository;

/**
 * This class runs the Book Store Application & initialises a couple books and
 * users
 **/

@SpringBootApplication
public class LensVaultApplication {

	public static void main(String[] args) {
		SpringApplication.run(LensVaultApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(PrimeOrZoomRepository primeOrZoomRepository, LensRepository lensRepository,
			UserRepository urepository, MountRepository mountRepository) {
		return (args) -> {
			// objects created
			/*
			System.out.println("Preloaded categories created");
			primeOrZoomRepository.save(new PrimeOrZoom("Prime"));
			primeOrZoomRepository.save(new PrimeOrZoom("Zoom"));
			System.out.println("Category- Mount created");
			mountRepository.save(new Mount("M42"));
			mountRepository.save(new Mount("Canon FD"));
			mountRepository.save(new Mount("A"));
			mountRepository.save(new Mount("E"));
			// Book objects created
			System.out.println("Preloaded lenses created");
			lensRepository
					.save(new Lens("Helios", "44-2", 58.00, 2.00, 16.00, primeOrZoomRepository.findByName("Prime").get(0),
							mountRepository.findByName("M42").get(0), "USSR", 1980, 7471877, "Good condition"));
			lensRepository.save(new Lens("Pentacon", "Meyer-Optik Görlitz Orestegor", 200.00, 4.00, 22.00,
					primeOrZoomRepository.findByName("Prime").get(0), mountRepository.findByName("M42").get(0),
					"East Germany", 1967, 4728864, "Good condition, zebra stripe"));
			lensRepository
					.save(new Lens("Pentacon", "", 135.00, 2.80, 32.00, primeOrZoomRepository.findByName("Prime").get(0),
							mountRepository.findByName("M42").get(0), "East Germany", 1970, 7390609, "Good condition"));
			lensRepository
					.save(new Lens("Pentacon", "", 200.00, 4.00, 22.00, primeOrZoomRepository.findByName("Prime").get(0),
							mountRepository.findByName("M42").get(0), "East Germany", 1967, 8512571, "Good condition"));
			lensRepository.save(new Lens("Tasman", "", 135.00, 2.80, 22.00,
					primeOrZoomRepository.findByName("Prime").get(0), mountRepository.findByName("M42").get(0),
					"Australia", 1980, 1238081, "Good condition, custom square aperture"));
			lensRepository
					.save(new Lens("Pentacon", "", 50.00, 2.80, 22.00, primeOrZoomRepository.findByName("Prime").get(0),
							mountRepository.findByName("M42").get(0), "East Germany", 1980, 0, "Good condition"));
			lensRepository.save(new Lens("Pentacon", "", 50.00, 1.80, 16.00,
					primeOrZoomRepository.findByName("Prime").get(0), mountRepository.findByName("M42").get(0),
					"East Germany", 1980, 0, "Good condition, custom paint"));
			lensRepository
					.save(new Lens("Sunagor", "", 28.00, 2.80, 22.00, primeOrZoomRepository.findByName("Prime").get(0),
							mountRepository.findByName("M42").get(0), "Japan", 1980, 760920, "Good condition"));
			lensRepository.save(new Lens("Helios", "44M-4", 58.00, 2.00, 16.00,
					primeOrZoomRepository.findByName("Prime").get(0), mountRepository.findByName("M42").get(0), "USSR",
					1980, 86159949, "Good condition, custom soft bokeh"));
			lensRepository
					.save(new Lens("Canon", "FD", 50.00, 1.40, 22.00, primeOrZoomRepository.findByName("Prime").get(0),
							mountRepository.findByName("Canon FD").get(0), "Japan", 1980, 1613784, "Good condition"));
			lensRepository
			.save(new Lens("Sony", "SAM II", 18.55, 3.50, 36.00, primeOrZoomRepository.findByName("Zoom").get(0),
					mountRepository.findByName("A").get(0), "Japan", 2010, 0, "Modern kit lens"));
			lensRepository
			.save(new Lens("Sony", "FE OSS", 28.70, 3.50, 22.00, primeOrZoomRepository.findByName("Zoom").get(0),
					mountRepository.findByName("E").get(0), "Japan", 2010, 0, "Modern kit lens"));
			
			lensRepository
			.save(new Lens("Zenitar", "M", 16.00, 2.80, 22.00, primeOrZoomRepository.findByName("Prime").get(0),
					mountRepository.findByName("M42").get(0), "Russia", 2000, 0, "Modern fish-eye"));
			
			// Create 2 users (basic user and admin). Attributes: username (unique),
			// password, role, email
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER",
					"user@evilcorp.com");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN",
					"admin@evilcorp.com");
			urepository.save(user1);
			urepository.save(user2);
			*/
			System.out.println("fetch all lenses");
			for (Lens lens : lensRepository.findAll()) {
				System.out.println(lens.toString());
			}
		};
	}
}