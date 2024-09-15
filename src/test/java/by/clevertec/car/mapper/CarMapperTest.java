package by.clevertec.car.mapper;

import by.clevertec.car.domain.Car;
import by.clevertec.car.entity.CarEntity;
import by.clevertec.car.util.TestHelper;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CarMapperTest {

    TestHelper testHelper = new TestHelper();
    CarMapper carMapper = new CarMapperImpl();

    @ParameterizedTest
    @MethodSource
    void shouldMappingCarsToEntities(List<Car> cars, List<CarEntity> expectedEntities){

        //when
        List<CarEntity> actualEntities = carMapper.toCarEntities(cars);
        //then
        assertThat(actualEntities).isEqualTo(expectedEntities);
    }

    public static Stream<Arguments> shouldMappingCarsToEntities(){
        TestHelper testHelper = new TestHelper();
        return Stream.of(
                Arguments.of(testHelper.getAllCars(), testHelper.getAllCarEntities()),
                Arguments.of(testHelper.getAllCars().subList(0,1), testHelper.getAllCarEntities().subList(0,1)),
                Arguments.of(List.of(), List.of()),
                Arguments.of(null, null)
        );
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