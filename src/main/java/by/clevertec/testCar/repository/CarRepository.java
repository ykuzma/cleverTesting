package by.clevertec.testCar.repository;

import by.clevertec.testCar.common.CarType;
import by.clevertec.testCar.entity.CarEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;


public class CarRepository {
    private static List<CarEntity> cars = List.of(
            new CarEntity(UUID.randomUUID(), 2, 2, 2, CarType.CROSSOVER),
            new CarEntity(UUID.randomUUID(), 2, 2, 2, CarType.SEDAN)
    );

    public List<CarEntity> getCars() {
        return cars;
    }
}
