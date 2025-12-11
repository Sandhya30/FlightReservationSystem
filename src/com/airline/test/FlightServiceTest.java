package com.airline.test;

import com.airline.model.Flight;
import com.airline.model.Reservation;
import com.airline.service.FlightService;

import java.time.LocalDateTime;
import java.util.List;


public class FlightServiceTest {

    public static void main(String[] args) {

        FlightService service = new FlightService();
        System.out.println("=== RUNNING COMPREHENSIVE FLIGHT SERVICE TESTS ===\n");

        
        System.out.println("[Test 1] Search flights Hyderabad tomorrow:");
        List<Flight> flights = service.searchFlights("Hyderabad", LocalDateTime.now().plusDays(1));
        System.out.println("Flights found: " + flights.size() + " ✅\n");

        
        System.out.println("[Test 2] Search flights to invalid destination:");
        flights = service.searchFlights("Mars", LocalDateTime.now().plusDays(1));
        System.out.println("Flights found: " + flights.size() + " ✅ (Expected 0)\n");

        
        System.out.println("[Test 3] Search flights with empty destination:");
        flights = service.searchFlights("", LocalDateTime.now().plusDays(1));
        System.out.println("Flights found: " + flights.size() + " ✅ (Expected 0)\n");

        
        Flight flight1 = service.getAllFlights().get(0);
        System.out.println("[Test 4] Book 2 seats on flight " + flight1.getFlightNumber());
        int seatsBefore = flight1.getAvailableSeats();
        Reservation res1 = service.bookFlight("Chotu", flight1, 2);
        int seatsAfter = flight1.getAvailableSeats();
        System.out.println("Seats before: " + seatsBefore);
        System.out.println("Seats after: " + seatsAfter);
        System.out.println("Reservation: " + (res1 != null ? "SUCCESS ✅" : "FAILED ❌") + "\n");

        
        System.out.println("[Test 5] Overbooking 1000 seats on flight " + flight1.getFlightNumber());
        Reservation overbook = service.bookFlight("TestUser", flight1, 1000);
        System.out.println("Reservation: " + (overbook == null ? "FAILED as expected ✅" : "ERROR ❌") + "\n");

        
        System.out.println("[Test 6] Booking 0 seats (invalid)");
        try {
            service.bookFlight("Chotu", flight1, 0);
            System.out.println("ERROR ❌ Booking allowed with 0 seats");
        } catch (IllegalArgumentException e) {
            System.out.println("Passed ✅ Exception caught: " + e.getMessage() + "\n");
        }

        
        System.out.println("[Test 7] Booking -5 seats (invalid)");
        try {
            service.bookFlight("Chotu", flight1, -5);
            System.out.println("ERROR ❌ Booking allowed with negative seats");
        } catch (IllegalArgumentException e) {
            System.out.println("Passed ✅ Exception caught: " + e.getMessage() + "\n");
        }

        
        System.out.println("[Test 8] Booking with null flight");
        try {
            service.bookFlight("Chotu", null, 1);
            System.out.println("ERROR ❌ Booking allowed with null flight");
        } catch (IllegalArgumentException e) {
            System.out.println("Passed ✅ Exception caught: " + e.getMessage() + "\n");
        }

        
        System.out.println("[Test 9] Booking with null customer name");
        try {
            service.bookFlight(null, flight1, 1);
            System.out.println("ERROR ❌ Booking allowed with null customer name");
        } catch (IllegalArgumentException e) {
            System.out.println("Passed ✅ Exception caught: " + e.getMessage() + "\n");
        }

        
        System.out.println("[Test 10] Multiple bookings on flight " + flight1.getFlightNumber());
        Flight flight2 = service.getAllFlights().get(1);
        System.out.println("Initial seats: " + flight2.getAvailableSeats());
        Reservation r1 = service.bookFlight("Alice", flight2, 3);
        Reservation r2 = service.bookFlight("Bob", flight2, 2);
        System.out.println("Seats after bookings: " + flight2.getAvailableSeats());
        System.out.println("Reservation Alice: " + (r1 != null ? "SUCCESS ✅" : "FAILED ❌"));
        System.out.println("Reservation Bob: " + (r2 != null ? "SUCCESS ✅" : "FAILED ❌") + "\n");

        
        System.out.println("[Final] Display all reservations:");
        List<Reservation> allReservations = service.getAllReservations();
        for (Reservation r : allReservations) {
            System.out.println(r);
            System.out.println("------------------------");
        }

        System.out.println("\n=== ALL TESTS COMPLETED SUCCESSFULLY ===");
    }
}
