package com.example.mvccar.controller;

import com.example.mvccar.model.Car;
import com.example.mvccar.service.CarService;
import com.example.mvccar.service.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cars")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String getAllCar(Model model) {
        model.addAttribute("cars", carService.getAllCar());
        return "cars";
    }

    @GetMapping("new_car")
    public String newCarForm(Model model) {
        model.addAttribute("car", new Car());
        return "new_car";
    }

    @GetMapping("/{id}")
    public String getCarById(@PathVariable int id, Model model) {
        model.addAttribute("car", carService.getCarById(id));
        return "update_car";
    }

    @GetMapping("/colors")
    public String showCarByColor(@RequestParam String color, Model model) {
        model.addAttribute("car", carService.getCarByColor(color));
        return "car";
    }

    @PostMapping()
    public String saveCar(@ModelAttribute("car") Car car) {
        carService.createCar(car);
        return "redirect:/cars";
    }

    @GetMapping("/update/{id}")
    public String updateCar(@PathVariable int id, Model model) {
        model.addAttribute("car", carService.putCar(id));
        return "update_car";
    }

    @GetMapping("delete/{id}")
    public String deleteCar(@PathVariable int id, Model model) {
        model.addAttribute("car", carService.deleteCarById(id));
        return "redirect:/cars";
    }
}
