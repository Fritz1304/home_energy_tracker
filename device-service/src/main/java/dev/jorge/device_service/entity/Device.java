package dev.jorge.device_service.entity;

import dev.jorge.device_service.model.DeviceType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="device")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Device{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private DeviceType type;
    private String location;
    private Long userId;
}
