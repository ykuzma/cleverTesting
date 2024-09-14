package by.clevertec.car.mapper;


import by.clevertec.car.domain.Car;
import by.clevertec.car.entity.CarEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {
    List<Car> toCars(List<CarEntity> cars);

    List<CarEntity> toCarEntities(List<Car> cars);

    Car toCar(CarEntity carEntity);

    CarEntity toCarEntity (Car car);
}
