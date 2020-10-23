package com.flight.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "flight")
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String flightNumber;
	private String source;
	private String destination;
	private Date flightDate;
	private double fare;
	private String airlineName;
	
	
	
	public Flight() {
		super();
	}
	public Flight(int flightId, String flightNumber, String source, String destination, Date flightDate, double fare, String airlineName) {
		super();
		this.id = flightId;
		this.flightNumber = flightNumber;
		this.source = source;
		this.destination = destination;
		this.flightDate = flightDate;
		this.fare = fare;
		this.airlineName = airlineName;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Date getFlightDate() {
		return flightDate;
	}
	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

}