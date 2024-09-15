package by.clevertec.car.controllers;

import by.clevertec.car.domain.Car;
import by.clevertec.car.services.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public List<Car> getCars() {

        return carService.getCars();
    }

    @GetMapping("/{id}")
    public Car getCarsById(@PathVariable UUID id) {

        return carService.getCarById(id);
    }

    @DeleteMapping("/{id}")
    void deleteCarById(@PathVariable UUID id) {
        carService.delete(id);
    }
}
