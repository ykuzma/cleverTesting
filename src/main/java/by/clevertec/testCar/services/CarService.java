package by.clevertec.testCar.services;

import by.clevertec.testCar.domain.Car;
import by.clevertec.testCar.entity.CarEntity;
import by.clevertec.testCar.mapper.CarMapper;
import by.clevertec.testCar.mapper.CarMapperImpl;
import by.clevertec.testCar.repository.CarRepository;

import java.util.List;

public class CarService {
    private final CarRepository repository = new CarRepository();
    private final CarMapper mapper = new CarMapperImpl();

    public List<Car> getCars(){
        List<CarEntity> cars = repository.getCars();

        return mapper.toCars(cars);
    }
}
