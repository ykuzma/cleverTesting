package by.clevertec.car.services;

import by.clevertec.car.domain.Car;
import by.clevertec.car.entity.CarEntity;
import by.clevertec.car.mapper.CarMapper;
import by.clevertec.car.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository repository;
    private final CarMapper mapper;

    public List<Car> getCars() {
        List<CarEntity> cars = repository.findAll();
        return mapper.toCars(cars);
    }

    public Car getCarById(UUID uuid) {
        CarEntity carEntity = repository.findById(uuid).orElseThrow();
        return mapper.toCar(carEntity);
    }

    public Car create(Car car) {
        CarEntity carEntity = mapper.toCarEntity(car);
        CarEntity save = repository.save(carEntity);
        return mapper.toCar(save);
    }

    public Car update(Car newCar, UUID id) {
        CarEntity updatedEntity = repository.findById(id)
                .map(entity -> updateEntity(newCar, entity))
                .orElseThrow();

        return mapper.toCar(repository.save(updatedEntity));
    }

    private CarEntity updateEntity(Car newCar, CarEntity entity) {
        entity.setVehicleMileage(newCar.getVehicleMileage());
        entity.setTrunkCapacity(newCar.getTrunkCapacity());
        entity.setDoorCount(newCar.getDoorCount());
        entity.setCarType(newCar.getCarType());
        return entity;
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

}
