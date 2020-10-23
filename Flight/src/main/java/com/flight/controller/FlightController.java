package com.flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.flight.model.Flight;
import com.flight.service.FlightService;


@Controller
public class FlightController {
  @Autowired
  FlightService flightService;
	
	
	@GetMapping(value="/allFlight")
	public ResponseEntity<?> flightList()
	{
		return new ResponseEntity<List<Flight>>(flightService.allFlight(),HttpStatus.OK);
	}
	
	@GetMapping(value="/searchFlightById/{id}")
	public ResponseEntity<?> searchFlightById(@PathVariable("id") String id)
	{
		Flight s = flightService.searchFlightById(id);
		if(s==null){
			return new ResponseEntity<String>("Stock ID not found!!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Flight>(s,HttpStatus.OK);
	}
	
	
	
	
	@GetMapping(value="/searchFlightBySourceAndDestination/{source}/{destination}")
	public ResponseEntity<?> searchFlightBySourceAndDestination(@PathVariable("source") String source, @PathVariable("destination") String destination )
	{
		List<Flight> s = flightService.searchFlightBySourceAndDestination(source,destination);
		if(s.size()==0){
			return new ResponseEntity<String>("No flights found between given locations!!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Flight>>(s,HttpStatus.OK);
	}
	
	@GetMapping(value="/searchFlightByAirline/{airline}")
	public ResponseEntity<?> searchFlightByAirline(@PathVariable("airline") String airline)
	{
		List<Flight> s = flightService.searchFlightByAirline(airline);
		if(s.size()==0){
			return new ResponseEntity<String>("No filghts found for given airline!!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Flight>>(s,HttpStatus.OK);
	}
	
}
