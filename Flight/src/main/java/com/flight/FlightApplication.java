package com.flight;

import java.text.SimpleDateFormat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.flight.model.Flight;
import com.flight.repo.FlightRepo;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
public class FlightApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightApplication.class, args);
	}
	
	@Bean
	CommandLineRunner initDatabase(final FlightRepo repository) {

		final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return args -> {
			repository.save(new Flight(1,"I123", "Pune", "Goa", format.parse("2020-01-01"), 1500, "Indigo"));
			repository.save(new Flight(2,"I234", "Delhi", "Kolkata", format.parse("2020-02-01"), 2000, "Indigo"));
			repository.save(new Flight(3,"V453", "Mumbai", "Hyderabad", format.parse("2020-04-01"), 1800, "Vistara"));
			repository.save(new Flight(4,"G615", "Pune", "Goa", format.parse("2019-04-01"), 2480, "Go Air"));
			repository.save(new Flight(5,"G582", "Bangalore", "Kolkata", format.parse("2018-04-01"), 1675, "Go Air"));
			repository.save(new Flight(6,"J847", "Chennai", "Pune", format.parse("2017-01-01"), 1300, "Jet Airways"));
		};
	}

}
