CREATE TABLE car (
    id LONG PRIMARY KEY AUTO_INCREMENT, -- Unique identifier for each car
    make VARCHAR(255),                    -- Car make (e.g., Toyota, Honda)
    model VARCHAR(255),                   -- Car model (e.g., Camry, Accord)
    makeYear INT,                         -- Year the car was manufactured
    price DOUBLE,                         -- Price of the car
    color VARCHAR(255),                   -- Color of the car
    mileage INT                           -- Mileage of the car
);
