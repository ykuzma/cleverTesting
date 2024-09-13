package by.clevertec.testCar.controllers;

import by.clevertec.testCar.domain.Car;
import by.clevertec.testCar.services.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    List<Car> getCars() {

        return carService.getCars();
    }
}
