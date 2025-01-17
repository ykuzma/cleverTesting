package by.clevertec.car.repository;

import by.clevertec.car.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface CarRepository extends JpaRepository<CarEntity, UUID>,
        JpaSpecificationExecutor<CarEntity> {


}
