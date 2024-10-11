package ca.sheridancollege.munjalru.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Lombok annotation to generate getters, setters, equals, hashCode, and toString methods
@NoArgsConstructor // Lombok annotation to generate a no-argument constructor

public class Car {
    private Long id;        // Unique identifier for the car
    private String make;     // Car manufacturer (e.g., Toyota, Honda)
    private String model;    // Car model (e.g., Corolla, Civic)
    private int makeYear;    // Year the car was manufactured
    private double price;    // Price of the car
    private String color;    // Color of the car
    private int mileage;     // Car's mileage (distance traveled)
}