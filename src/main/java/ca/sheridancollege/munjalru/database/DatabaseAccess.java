package ca.sheridancollege.munjalru.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.munjalru.beans.Car;

@Repository // Marks this class as a Spring repository for database operations
public class DatabaseAccess {

    @Autowired
    protected NamedParameterJdbcTemplate jdbc; // Autowires the JDBC template for executing SQL queries

    // Method to insert a new car into the database
    public void insertCar(Car car) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("make", car.getMake());
        namedParameters.addValue("model", car.getModel());
        namedParameters.addValue("makeYear", car.getMakeYear());
        namedParameters.addValue("price", car.getPrice());
        namedParameters.addValue("color", car.getColor());
        namedParameters.addValue("mileage", car.getMileage());

        String query = "INSERT INTO car(make, model, makeYear, price, color, mileage) VALUES (:make, :model, :makeYear, :price, :color, :mileage)";
        jdbc.update(query, namedParameters); // Executes the SQL query to insert the car
    }

    // Method to retrieve a list of all cars from the database
    public List<Car> getCarList() {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "SELECT * FROM car";
        return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Car>(Car.class)); // Maps query results to Car objects
    }

    // Method to delete a car from the database by its ID
    public void deleteCarById(Long id) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "DELETE FROM car WHERE id = :id";
        namedParameters.addValue("id", id);
        jdbc.update(query, namedParameters); // Executes the SQL query to delete the car
    }
}