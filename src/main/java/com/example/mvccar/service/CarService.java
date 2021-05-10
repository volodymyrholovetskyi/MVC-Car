package com.example.mvccar.service;


import com.example.mvccar.model.Car;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CarService {

    List<Car> getAllCar();

    Car getCarById(int id);

    Car getCarByColor(String color);

    void createCar(Car car);

    Car deleteCarById(int id);

    Car putCar(int id);
}
