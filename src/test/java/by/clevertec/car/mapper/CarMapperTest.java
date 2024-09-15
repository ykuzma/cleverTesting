package by.clevertec.car.mapper;

import by.clevertec.car.domain.Car;
import by.clevertec.car.entity.CarEntity;
import by.clevertec.car.util.TestHelper;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarMapperTest {

    TestHelper testHelper = new TestHelper();
    CarMapper carMapper = new CarMapperImpl();

    @Test
    void shouldMappingCarsToEntities(){
        //given
        List<Car> allCars = testHelper.getAllCars();
        List<CarEntity> expectedEntities = testHelper.getAllCarEntities();
        //when
        List<CarEntity> actualEntities = carMapper.toCarEntities(allCars);
        //then
        assertThat(actualEntities).isEqualTo(expectedEntities);
    }

    @Test
    void shouldMappingCarsToEntities_whenListEmpty(){
        //given
        List<Car> allCars = List.of();
        //when
        List<CarEntity> actualEntities = carMapper.toCarEntities(allCars);
        //then
        assertThat(actualEntities).isEmpty();
    }

    @RepeatedTest(10)
    void shouldMappingEntityToCar() {
        //given
        CarEntity carEntity = testHelper.getRandomCarEntity();

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
        Car car = testHelper.getRandomCar();
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