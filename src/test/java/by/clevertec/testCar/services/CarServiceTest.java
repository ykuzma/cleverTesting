package by.clevertec.testCar.services;

import by.clevertec.testCar.domain.Car;
import by.clevertec.testCar.entity.CarEntity;
import by.clevertec.testCar.mapper.CarMapperImpl;
import by.clevertec.testCar.repository.CarRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CarServiceTest {
    @Mock
    CarRepository carRepository;
    @Spy
    CarMapperImpl carMapper;
    @InjectMocks
    CarService carService;

/*    private CarRepository carRepository = mock(CarRepository.class);
    private CarService carService = new CarService(carRepository);*/
    @Test
    void shouldGetCars() {
        //given
        when(carRepository.getCars()).thenReturn(List.of(new CarEntity()));
        //when
        List<Car> cars = carService.getCars();

        //then
        assertThat(cars).isEqualTo(List.of(new Car()));

    }
}