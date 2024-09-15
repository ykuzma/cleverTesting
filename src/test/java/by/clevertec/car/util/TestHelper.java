package by.clevertec.car.util;

import by.clevertec.car.common.CarType;
import by.clevertec.car.domain.Car;
import by.clevertec.car.entity.CarEntity;
import org.jeasy.random.EasyRandom;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TestHelper {

    private final List<Car> allCars = new ArrayList<>();
    private final List<CarEntity> allCarEntities = new ArrayList<>();
    private final EasyRandom easyRandom = new EasyRandom();

    public TestHelper() {

        allCars.add(new Car(UUID.nameUUIDFromBytes("1".getBytes()), 10, 8, 9, CarType.CROSSOVER));
        allCars.add(new Car(UUID.nameUUIDFromBytes("2".getBytes()), 9, 2, 52, CarType.HATCHBACK));
        allCars.add(new Car(UUID.nameUUIDFromBytes("3".getBytes()), 1, 11, 2, CarType.PICKUP));
        allCars.add(new Car(UUID.nameUUIDFromBytes("2".getBytes()), 1, 11, 2, CarType.SEDAN));
        allCars.add(new Car(UUID.nameUUIDFromBytes("5".getBytes()), 342, 3, 4543, CarType.CROSSOVER));

        allCarEntities.add(new CarEntity(UUID.nameUUIDFromBytes("1".getBytes()), 10, 8, 9, CarType.CROSSOVER));
        allCarEntities.add(new CarEntity(UUID.nameUUIDFromBytes("2".getBytes()), 9, 2, 52, CarType.HATCHBACK));
        allCarEntities.add(new CarEntity(UUID.nameUUIDFromBytes("3".getBytes()), 1, 11, 2, CarType.PICKUP));
        allCarEntities.add(new CarEntity(UUID.nameUUIDFromBytes("2".getBytes()), 1, 11, 2, CarType.SEDAN));
        allCarEntities.add(new CarEntity(UUID.nameUUIDFromBytes("5".getBytes()), 342, 3, 4543, CarType.CROSSOVER));

    }

    public List<Car> getAllCars() {
        return allCars;
    }
    public List<Car> getCarsByType(CarType carType, List<Car> cars) {
        return cars.stream()
                .filter(car -> car.getCarType().equals(carType))
                .toList();
    }

    public Car getCarById(UUID id) {
        return allCars.stream()
                .filter(car -> car.getId().equals(id))
                .findAny().orElse(null);
    }

    public List<CarEntity> getAllCarEntities() {
        return allCarEntities;
    }

    public CarEntity getCarEntityById(UUID id) {
        return allCarEntities.stream()
                .filter(car -> car.getId().equals(id))
                .findAny().orElse(null);
    }

    public Car getRandomCar() {
        return easyRandom.nextObject(Car.class);
    }

    public CarEntity getRandomCarEntity() {
        return easyRandom.nextObject(CarEntity.class);
    }
    public Specification<CarEntity> getMockSpecification() {
        return (a, b, c) -> null;
    }

}
