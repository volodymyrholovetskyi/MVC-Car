package com.example.mvccar.service;

import com.example.mvccar.model.Car;
import com.example.mvccar.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCar() {
        List<Car> allList = carRepository.getAllList();
        return allList;
    }

    public Car getCarById(int id) {
        List<Car> allCar = carRepository.getAllList();
        Optional<Car> first = allCar.stream().filter(car -> car.getId() == id).findFirst();
        Car car = null;
        if (first.isPresent()) {
            car = first.get();
        } else throw new RuntimeException(" Car not found for id :: " + id);
        return car;
    }

    public Car getCarByColor(String color) {
        List<Car> allCar = carRepository.getAllList();
        Optional<Car> first = allCar.stream().filter(car -> car.getColor().equalsIgnoreCase(color)).findFirst();
        Car car = null;
        if (first.isPresent()) {
            car = first.get();
        } else throw new RuntimeException(" Car not found for color :: " + color);
        return car;
    }

    public void createCar(Car car) {
        carRepository.createCar(car.getId(), car.getMark(), car.getModel(), car.getColor());
    }


    public Car deleteCarById(int id) {
        List<Car> allList = carRepository.getAllList();
        Optional<Car> first =
                allList.stream().filter(car -> car.getId() == id).findFirst();
        if (first.isPresent()) {
            carRepository.deleteCar(first.get());
            return first.get();
        }
        return first.get();
    }

    public Car putCar(int id) {
        List<Car> allList = carRepository.getAllList();
        Optional<Car> first = allList.stream().filter(car -> car.getId() == id).findFirst();
        Car car = null;
        if (first.isPresent()) {
            carRepository.deleteCar(first.get());
            car = first.get();
            System.out.println(car);
        }
        return car;
    }

}

