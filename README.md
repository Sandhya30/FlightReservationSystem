# Flight Reservation System

## Overview
This project is a **console-based Flight Reservation System** implemented in Java.  
It allows users to:

- Search for available flights by destination and date.
- Book flights with seat availability checks.
- View all reservations made.

The system uses **in-memory data structures (List)** to manage flights and reservations.  
It also includes a comprehensive test class to validate all functionalities.

---

---

## Technologies Used

- Java 8
- NetBeans 8 IDE
- Console-based UI
- In-memory storage (List)

---

## Setup Instructions

1. Clone or download the repository.
2. Open NetBeans 8 → **File → Open Project** → Select `FlightReservationSystem`.
3. Ensure **JDK 8** is configured in NetBeans.
4. Build the project (Clean & Build).
5. Run the **Main class**:
   - Right-click `Main.java` → Run File
6. Run the **Test class** (optional, recommended):
   - Right-click `FlightServiceTest.java` → Run File

---

## Usage

### Main Application

1. **Search Flights**
   - Enter destination and days from today.
   - Lists all matching flights.

2. **Book Flight**
   - Enter customer name.
   - Select flight from the list.
   - Enter number of seats.
   - System confirms booking or shows failure if seats unavailable.

3. **View Reservations**
   - Displays all reservations with details:
     - Customer Name
     - Flight Number
     - Destination
     - Seats Booked
     - Booking Time

4. **Exit**
   - Closes the application.

---

### Test Class (`FlightServiceTest.java`)

- Validates all functionalities including edge cases:
  - Searching flights with valid/invalid destinations
  - Booking valid and invalid number of seats
  - Overbooking scenarios
  - Booking with null flight or customer name
  - Multiple reservations and seat decrements
- Prints **clear output** for each test with results and reservation details.

---

## Design Decisions

- In-memory data storage for simplicity.
- Validations in constructors and methods to prevent invalid state.
- Separation of concerns:
  - `Flight` and `Reservation` → Model
  - `FlightService` → Business logic
  - `Main` → UI
  - `FlightServiceTest` → Testing
- Console-based interface for lightweight and easy-to-run assessment.

---

## Future Enhancements

- Add flight cancellation feature.
- Sort/filter flights by departure time.
- Add GUI (JavaFX/Swing).
- Integrate database for persistent storage.
- Implement JUnit tests for professional testing coverage.

---

## Author

- Name: Sandhya Potnuru 
- Role: Software Engineer

