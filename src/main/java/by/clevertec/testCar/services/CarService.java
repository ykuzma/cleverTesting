package by.clevertec.testCar.services;

import by.clevertec.testCar.domain.Car;
import by.clevertec.testCar.entity.CarEntity;
import by.clevertec.testCar.mapper.CarMapper;
import by.clevertec.testCar.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository repository;
    private final CarMapper mapper;

    public List<Car> getCars(){
        List<CarEntity> cars = repository.findAll();
        return mapper.toCars(cars);
    }

    public Car getCarById(UUID uuid) {
        CarEntity carEntity = repository.findById(uuid).orElseThrow();
        return mapper.toCar(carEntity);
    }

    public Car create (Car car) {
        CarEntity carEntity = mapper.toCarEntity(car);
        CarEntity save = repository.save(carEntity);
        return mapper.toCar(save);
    }

    public Car update(Car car) {
        CarEntity save = repository.save(mapper.toCarEntity(car));
        return mapper.toCar(save);
    }

    public void delete(Car car) {
        repository.delete(mapper.toCarEntity(car));
    }

}
