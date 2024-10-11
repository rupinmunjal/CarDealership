package ca.sheridancollege.munjalru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.munjalru.beans.Car;
import ca.sheridancollege.munjalru.database.DatabaseAccess;

@Controller
public class CarController {

    @Autowired
    private DatabaseAccess da; // Autowires the DatabaseAccess class for database operations

    // Display the homepage with a list of cars
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("car", new Car()); // Add a new Car object for form binding
        model.addAttribute("carList", da.getCarList()); // Add the list of cars from the database
        return "index"; // Return the view 'index'
    }
    
    // Display the form to insert a new car
    @GetMapping("/insertCar")
    public String insertCar(Model model) {
        model.addAttribute("car", new Car()); // Add a new Car object for form binding
        model.addAttribute("carList", da.getCarList()); // Add the list of cars from the database
        return "insertCar"; // Return the view 'insertCar'
    }
    
    // Handle form submission to insert a new car
    @PostMapping("/insertCar")
    public String insertCar(Model model, @ModelAttribute Car car) {
        da.insertCar(car); // Insert the new car into the database
        model.addAttribute("carList", da.getCarList()); // Refresh the list of cars
        model.addAttribute("car", new Car()); // Reset the form with a new Car object
        return "insertCar"; // Return the same 'insertCar' view
    }

    // Handle the deletion of a car by its ID
    @GetMapping("/deleteCarById/{id}")
    public String deleteCarById(@PathVariable Long id) {
        da.deleteCarById(id); // Delete the car from the database
        return "redirect:/"; // Redirect back to the homepage after deletion
    }
}