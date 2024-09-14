package by.clevertec.testCar.services;

import by.clevertec.testCar.domain.Car;
import by.clevertec.testCar.entity.CarEntity;
import by.clevertec.testCar.mapper.CarMapperImpl;
import by.clevertec.testCar.repository.CarRepository;
import by.clevertec.testCar.util.TestHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CarServiceTest {

    TestHelper testHelper = new TestHelper();
    @Mock
    CarRepository carRepository;
    @Spy
    CarMapperImpl carMapper;
    @InjectMocks
    CarService carService;

    @Test
    void shouldGetCars() {
        //given
        List<CarEntity> entities = testHelper.getAllCarEntities();
        List<Car> expectedCars = testHelper.getAllCars();
        when(carRepository.findAll()).thenReturn(entities);
        //when
        List<Car> actualCars = carService.getCars();

        //then
        assertThat(actualCars).isEqualTo(expectedCars);
    }

    @Test
    void shouldGetCarById() {
        //given
        UUID id = UUID.nameUUIDFromBytes("1".getBytes());
        CarEntity carEntity = testHelper.getCarEntityById(id);
        Car carExpected = testHelper.getCarById(id);
        when(carRepository.findById(id)).thenReturn(Optional.of(carEntity));
        //when
        Car actualCar = carService.getCarById(id);
        //then
        assertThat(actualCar).isEqualTo(carExpected);
    }


    @Test
    void shouldCreateCar() {

    }

    @Test
    void shouldUpdateCar() {

    }

    @Test
    void shouldDeleteCars() {
        //given
        UUID id = UUID.randomUUID();
        //when
        carService.delete(id);
        //then
        verify(carRepository).deleteById(id);
    }

}