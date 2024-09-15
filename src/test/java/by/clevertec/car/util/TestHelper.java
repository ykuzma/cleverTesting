package by.clevertec.car.util;

import by.clevertec.car.common.CarType;
import by.clevertec.car.domain.Car;
import by.clevertec.car.entity.CarEntity;
import org.jeasy.random.EasyRandom;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TestHelper {

    private final List<Car> allCars = new ArrayList<>();
    private final List<CarEntity> allCarEntities = new ArrayList<>();

    public TestHelper() {

        allCars.add(new Car(UUID.nameUUIDFromBytes("1".getBytes()), 10, 8, 9, CarType.CROSSOVER));
        allCars.add(new Car(UUID.nameUUIDFromBytes("2".getBytes()), 9, 2, 52, CarType.HATCHBACK));
        allCars.add(new Car(UUID.nameUUIDFromBytes("3".getBytes()), 1, 11, 2, CarType.PICKUP));
        allCars.add(new Car(UUID.nameUUIDFromBytes("2".getBytes()), 1, 11, 2, CarType.PICKUP));
        allCars.add(new Car(UUID.nameUUIDFromBytes("5".getBytes()), 342, 3, 4543, CarType.CROSSOVER));

        allCarEntities.add(new CarEntity(UUID.nameUUIDFromBytes("1".getBytes()), 10, 8, 9, CarType.CROSSOVER));
        allCarEntities.add(new CarEntity(UUID.nameUUIDFromBytes("2".getBytes()), 9, 2, 52, CarType.HATCHBACK));
        allCarEntities.add(new CarEntity(UUID.nameUUIDFromBytes("3".getBytes()), 1, 11, 2, CarType.PICKUP));
        allCarEntities.add(new CarEntity(UUID.nameUUIDFromBytes("2".getBytes()), 1, 11, 2, CarType.PICKUP));
        allCarEntities.add(new CarEntity(UUID.nameUUIDFromBytes("5".getBytes()), 342, 3, 4543, CarType.CROSSOVER));

    }

    public List<Car> getAllCars() {
        return allCars;
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

    private  EasyRandom easyRandom = new EasyRandom();

    public List<CarEntity> getRandomCarEntities() {
        return easyRandom.objects(CarEntity.class, 100).toList();
    }


}
