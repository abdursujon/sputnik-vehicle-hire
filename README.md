# Sputnik Vehicle Hire System

This project is a Java-based vehicle hire management system designed to model vehicles, customers, and reservations
using object-oriented principles and file-based data input and csv data processing. The system supports multiple vehicle 
types, date-based reservations, and full unit test coverage.

## Overview

The Vehicle Hire System is built with:
- **Java (JDK 17+)**
- **Gradle** for dependency management
- **JUnit 5** for testing
- **Text file–based data input through file selection manually**
- **Text file–based data input through auto resource integration**


The application reads vehicle, customer, and reservation data from structured text files, stores them in memory, 
and allows querying and printing through a console-driven interface. Demonstrating data processing and reading strategy. 

## Real-World Use Case

This type of system mirrors real rental platforms where:

- Vehicles are categorised into passenger and commercial types
- Reservations span multiple days
- Availability must be tracked per date
- Data may come from legacy flat files rather than databases

The design prioritises clarity, extensibility, and correctness over persistence or UI concerns.

## Prerequisites

- Java 21 (JDK 21)
- A Java-compatible IDE, such as IntelliJ IDEA

## How to run the project

- Can be run through IDE run button, or you can follow below instruction to build it from terminal. 

### Build the Project

```bash
./gradlew build
```
<p>Build a jar snaphot: dir build\libs</p>
<p>Run the jar for example: java -jar  sputnik-vehicle-hire-system-1.0-SNAPSHOT.jar </p>
<p>Choose option to run different items such as Car, Truck, Reservations in the terminal.</p>
<p>You can choose a file manually or you can choose option 1-5 for autoconfigured demo result.</p>

### Run All Tests
```bash
./gradlew test
```

## Core Features

### Vehicles
- **Vehicle**: Base class with common fields (make, model, engine, transmission, mileage, etc.)
- **Car**: Passenger vehicles with body type, doors, and seats
- **Commercial**: Base class for commercial vehicles with payload
- **Van**: Commercial vehicles with load volume and sliding side door
- **Truck**: Commercial vehicles with flexible feature lists

All vehicles are loaded from text files using a single-line CSV-style format.

---

### Reservations
- **BookingDetails**: Represents a reservation (vehicle, dates, duration)
- **Diary**: Date-based reservation calendar
- **ReservationSystem**: High-level orchestration of vehicles, customers, and bookings
- **DateUtil**: Date calculations and formatting

Multi-day reservations are expanded into per-day diary entries for fast date-based lookup.

---

### Customers
- **Customer**: Represents a customer who is avail to hire vehicle through the system.
