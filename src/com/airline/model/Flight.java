package com.airline.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Flight {

    private String flightNumber;
    private String destination;
    private LocalDateTime departureTime;
    private int availableSeats;

    public Flight(String flightNumber, String destination, LocalDateTime departureTime, int availableSeats) {
        if (flightNumber == null || flightNumber.trim().isEmpty())
            throw new IllegalArgumentException("Flight number cannot be empty");
        if (destination == null || destination.trim().isEmpty())
            throw new IllegalArgumentException("Destination cannot be empty");
        if (departureTime == null)
            throw new IllegalArgumentException("Departure time cannot be null");
        if (availableSeats < 0)
            throw new IllegalArgumentException("Available seats cannot be negative");

        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureTime = departureTime;
        this.availableSeats = availableSeats;
    }

    public String getFlightNumber() { return flightNumber; }
    public String getDestination() { return destination; }
    public LocalDateTime getDepartureTime() { return departureTime; }
    public int getAvailableSeats() { return availableSeats; }

    public boolean reserveSeats(int seats) {
        if (seats <= 0) throw new IllegalArgumentException("Seats must be greater than zero");
        if (availableSeats < seats) return false;
        availableSeats -= seats;
        return true;
    }

    @Override
    public String toString() {
        return flightNumber + " → " + destination +
                " | Departs: " + departureTime +
                " | Seats Available: " + availableSeats;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Flight)) return false;
        Flight other = (Flight) obj;
        return Objects.equals(flightNumber, other.flightNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightNumber);
    }
}
