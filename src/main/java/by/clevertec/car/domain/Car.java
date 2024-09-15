package by.clevertec.car.domain;

import by.clevertec.car.common.CarType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private UUID id;
    private long vehicleMileage;
    private int doorCount;
    private int trunkCapacity;
    private CarType carType;

}
