package com.flight.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.flight.model.Flight;

@Repository
public interface FlightRepo extends CrudRepository<Flight, Integer> {

	List<Flight> findBySourceAndDestination(String source, String destination);

	Flight findByFlightNumber(String string);

	List<Flight> findByAirlineName(String airline);

}
