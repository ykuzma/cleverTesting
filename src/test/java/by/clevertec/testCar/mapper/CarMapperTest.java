package by.clevertec.testCar.mapper;

import by.clevertec.testCar.common.CarType;
import by.clevertec.testCar.domain.Car;
import by.clevertec.testCar.entity.CarEntity;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class CarMapperTest {

    CarMapper carMapper = new CarMapperImpl();

    @Test
    void shouldMappingCarEntitiesToCars() {
       //given

       //when

       //then
    }

    @Test
    void toCarEntities() {

    }

    @RepeatedTest(10)
    void toCar() {
        //given
        EasyRandom easyRandom = new EasyRandom();
        CarEntity carEntity = easyRandom.nextObject(CarEntity.class);

        //when
        Car car = carMapper.toCar(carEntity);
        //then
        assertThat(car)
                .isNotNull()
                .hasFieldOrPropertyWithValue("id", carEntity.getId())
                .hasFieldOrPropertyWithValue("vehicleMileage", carEntity.getVehicleMileage())
                .hasFieldOrPropertyWithValue("doorCount", carEntity.getDoorCount())
                .hasFieldOrPropertyWithValue("carType", carEntity.getCarType())
                .hasFieldOrPropertyWithValue("trunkCapacity", carEntity.getTrunkCapacity());
    }



    @RepeatedTest(10)
    void toCarEntity() {
//given
        EasyRandom easyRandom = new EasyRandom();
        Car car = easyRandom.nextObject(Car.class);

        //when
        CarEntity carEntity = carMapper.toCarEntity(car);
        //then
        assertThat(carEntity)
                .isNotNull()
                .hasFieldOrPropertyWithValue("id", car.getId())
                .hasFieldOrPropertyWithValue("vehicleMileage", car.getVehicleMileage())
                .hasFieldOrPropertyWithValue("doorCount", car.getDoorCount())
                .hasFieldOrPropertyWithValue("carType", car.getCarType())
                .hasFieldOrPropertyWithValue("trunkCapacity", car.getTrunkCapacity());
    }
}