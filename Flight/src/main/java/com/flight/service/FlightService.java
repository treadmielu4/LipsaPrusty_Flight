package com.flight.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.model.Flight;
import com.flight.repo.FlightRepo;


@Service
public class FlightService {
	
	@Autowired
	FlightRepo flightRepo;

	public List<Flight> allFlight() {
		return (List<Flight>) flightRepo.findAll();
	
	}

	public Flight searchFlightById(String id) {
		Flight s = flightRepo.findByFlightNumber(id);
		if(s==null){
			return null;
		}
		return s;
	
	}

	public List<Flight> searchFlightBySourceAndDestination(String source, String destination) {
		return (List<Flight>) flightRepo.findBySourceAndDestination(source,destination);	
	
	}

	public List<Flight> searchFlightByAirline(String airline) {
		// TODO Auto-generated method stub
		return (List<Flight>) flightRepo.findByAirlineName(airline);	
	}

}
