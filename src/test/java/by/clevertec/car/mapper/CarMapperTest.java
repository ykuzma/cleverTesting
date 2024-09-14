package by.clevertec.car.mapper;

import by.clevertec.car.domain.Car;
import by.clevertec.car.entity.CarEntity;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class CarMapperTest {

    CarMapper carMapper = new CarMapperImpl();


    @RepeatedTest(10)
    void shouldMappingEntityToCar() {
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
    void shouldMappingCarToEntity() {
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