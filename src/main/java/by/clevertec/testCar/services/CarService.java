package by.clevertec.testCar.services;

import by.clevertec.testCar.domain.Car;
import by.clevertec.testCar.entity.CarEntity;
import by.clevertec.testCar.mapper.CarMapper;
import by.clevertec.testCar.repository.CarRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CarService {
    private final CarRepository repository;
    private final CarMapper mapper;

    public List<Car> getCars(){
        List<CarEntity> cars = repository.getCars();
        return mapper.toCars(cars);
    }
}
