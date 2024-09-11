package by.clevertec.testCar.domain;

import by.clevertec.testCar.common.CarType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private UUID id;
    private long vehicleMileage;
    private int doorCount;
    private int trunkCapacity;
    private CarType carType;

}
