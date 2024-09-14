package by.clevertec.testCar.entity;

import by.clevertec.testCar.common.CarType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CarEntity {
    @Id
    private UUID id;
    @Column
    private long vehicleMileage;
    @Column
    private int doorCount;
    @Column
    private int trunkCapacity;
    @Column
    private CarType carType;
}
