package com.airline.model;

import java.time.LocalDateTime;

public class Reservation {

    private String customerName;
    private Flight flight;
    private int seatsBooked;
    private LocalDateTime bookedAt;

    public Reservation(String customerName, Flight flight, int seatsBooked) {
        if (customerName == null || customerName.trim().isEmpty())
            throw new IllegalArgumentException("Customer name is required");
        if (flight == null)
            throw new IllegalArgumentException("Flight cannot be null");
        if (seatsBooked <= 0)
            throw new IllegalArgumentException("Seats booked must be greater than zero");

        this.customerName = customerName;
        this.flight = flight;
        this.seatsBooked = seatsBooked;
        this.bookedAt = LocalDateTime.now();
    }

    public String getCustomerName() { return customerName; }
    public Flight getFlight() { return flight; }
    public int getSeatsBooked() { return seatsBooked; }
    public LocalDateTime getBookedAt() { return bookedAt; }

    @Override
    public String toString() {
        return "Reservation Details:\n" +
                "Customer: " + customerName + "\n" +
                "Flight: " + flight.getFlightNumber() + "\n" +
                "Destination: " + flight.getDestination() + "\n" +
                "Seats Booked: " + seatsBooked + "\n" +
                "Time: " + bookedAt;
    }
}
