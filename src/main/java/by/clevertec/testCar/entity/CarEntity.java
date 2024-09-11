package by.clevertec.testCar.entity;

import by.clevertec.testCar.common.CarType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarEntity {
    private UUID id;
    private long vehicleMileage;
    private int doorCount;
    private int trunkCapacity;
    private CarType carType;
}
