package by.clevertec.car.entity;

import by.clevertec.car.common.CarType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

    @Enumerated(EnumType.STRING)
    @Column
    private CarType carType;
}
