package by.clevertec.car.services;

import by.clevertec.car.domain.Car;
import by.clevertec.car.entity.CarEntity;
import by.clevertec.car.mapper.CarMapperImpl;
import by.clevertec.car.repository.CarRepository;
import by.clevertec.car.util.TestHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;
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
    void whenIdNotFound_shouldThrowException() {
        //given
        UUID id = UUID.nameUUIDFromBytes("0".getBytes());
        when(carRepository.findById(id)).thenReturn(Optional.empty());

        //when, then
        assertThrows(NoSuchElementException.class, () -> carService.getCarById(id));
    }


    @Test
    void shouldCreateCar() {

    }

    @Test
    void shouldUpdateCar() {
        //given
        UUID id = UUID.nameUUIDFromBytes("2".getBytes());

        Car carUpdate = testHelper.getAllCars().get(2);
        Car carExpected = testHelper.getAllCars().get(3);

        when(carRepository.findById(id)).thenReturn(Optional.of(testHelper.getAllCarEntities().get(1)));
        when(carRepository.save(ArgumentMatchers.any())).thenReturn(testHelper.getAllCarEntities().get(3));
        //when
        Car carActual = carService.update(carUpdate, id);
        //then
        assertThat(carActual).isEqualTo(carExpected);
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