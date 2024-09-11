package by.clevertec.testCar.mapper;


import by.clevertec.testCar.domain.Car;
import by.clevertec.testCar.entity.CarEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CarMapper {
    List<Car> toCars(List<CarEntity> cars);
}
