package com.airline.service;

import com.airline.model.Flight;
import com.airline.model.Reservation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FlightService {

    private final List<Flight> flights = new ArrayList<>();
    private final List<Reservation> reservations = new ArrayList<>();

    public FlightService() {
        LocalDateTime base = LocalDateTime.now();
        flights.add(new Flight("FL101", "Hyderabad", base.plusDays(1), 40));
        flights.add(new Flight("FL102", "Delhi", base.plusDays(1), 25));
        flights.add(new Flight("FL103", "Mumbai", base.plusDays(2), 30));
        flights.add(new Flight("FL104", "Hyderabad", base.plusDays(2), 15));
    }

    public List<Flight> searchFlights(String destination, LocalDateTime dateTime) {
        if (destination == null || destination.trim().isEmpty() || dateTime == null)
            return Collections.emptyList();

        LocalDate targetDate = dateTime.toLocalDate();
        String normalizedDestination = destination.trim().toLowerCase();

        return flights.stream()
                .filter(f -> f.getDestination().toLowerCase().contains(normalizedDestination))
                .filter(f -> f.getDepartureTime().toLocalDate().equals(targetDate))
                .collect(Collectors.toList());
    }

    public Reservation bookFlight(String customerName, Flight flight, int seats) {
        if (flight == null) throw new IllegalArgumentException("Flight cannot be null");

        boolean success = flight.reserveSeats(seats);
        if (!success) return null;

        Reservation reservation = new Reservation(customerName, flight, seats);
        reservations.add(reservation);
        return reservation;
    }

    public List<Reservation> getAllReservations() { return new ArrayList<>(reservations); }
    public List<Flight> getAllFlights() { return new ArrayList<>(flights); }
}
