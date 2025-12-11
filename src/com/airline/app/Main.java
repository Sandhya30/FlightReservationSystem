package com.airline.app;

import com.airline.model.Flight;
import com.airline.model.Reservation;
import com.airline.service.FlightService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FlightService service = new FlightService();

        System.out.println("===== Flight Reservation System =====");

        while (true) {
            System.out.println("\n1. Search Flights");
            System.out.println("2. Book Flight");
            System.out.println("3. View Reservations");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice;
            try { choice = Integer.parseInt(scanner.nextLine()); }
            catch (Exception e) { System.out.println("Invalid input!"); continue; }

            switch (choice) {
                case 1:
                    System.out.print("Enter destination: ");
                    String dest = scanner.nextLine();
                    System.out.print("Enter days from today: ");
                    int days = Integer.parseInt(scanner.nextLine());
                    LocalDateTime date = LocalDateTime.now().plusDays(days);
                    List<Flight> results = service.searchFlights(dest, date);
                    if (results.isEmpty()) System.out.println("No flights found.");
                    else results.forEach(System.out::println);
                    break;

                case 2:
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    List<Flight> flights = service.getAllFlights();
                    for (int i = 0; i < flights.size(); i++)
                        System.out.println((i + 1) + ". " + flights.get(i));

                    System.out.print("Select flight number: ");
                    int index = Integer.parseInt(scanner.nextLine()) - 1;
                    if (index < 0 || index >= flights.size()) { System.out.println("Invalid selection!"); break; }

                    System.out.print("Enter number of seats: ");
                    int seats = Integer.parseInt(scanner.nextLine());

                    Flight selectedFlight = flights.get(index);
                    Reservation reservation = service.bookFlight(name, selectedFlight, seats);

                    if (reservation == null) System.out.println("Booking failed. Not enough seats.");
                    else {
                        System.out.println("Booking successful!");
                        System.out.println(reservation);
                    }
                    break;

                case 3:
                    List<Reservation> reservations = service.getAllReservations();
                    if (reservations.isEmpty()) System.out.println("No reservations yet.");
                    else {
                        reservations.forEach(r -> { System.out.println(r); System.out.println("------------------------"); });
                    }
                    break;

                case 4:
                    System.out.println("Thank you. Exiting...");
                    return;

                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
