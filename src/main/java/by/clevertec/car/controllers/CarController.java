package by.clevertec.car.controllers;

import by.clevertec.car.common.CarType;
import by.clevertec.car.common.CriteriaCar;
import by.clevertec.car.domain.Car;
import by.clevertec.car.services.CarService;
import by.clevertec.car.util.CarErrorResponse;
import by.clevertec.car.util.CarNotFountException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @ExceptionHandler
    private ResponseEntity<CarErrorResponse> handleException(CarNotFountException exception) {
        CarErrorResponse response = new CarErrorResponse("Car not found");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public List<Car> getCars(@RequestParam(required = false) CarType carType) {
        CriteriaCar criteriaCar = new CriteriaCar(carType);
        return carService.getCars(criteriaCar);
    }

    @GetMapping("/{id}")
    public Car getCarsById(@PathVariable UUID id) {

        return carService.getCarById(id);
    }

    @PostMapping
    public Car createCar(@RequestBody Car car) {
        return carService.create(car);
    }

    @PostMapping("/{id}")
    public Car updateCar(@PathVariable UUID id, @RequestBody Car car) {
        return carService.update(car, id);
    }
    @DeleteMapping("/{id}")
    public void deleteCarById(@PathVariable UUID id) {
        carService.delete(id);
    }
}
