package dev.jorge.device_service.dto;

import dev.jorge.device_service.model.DeviceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DeviceDto {
    private Long id;
    private String name;
    private DeviceType deviceType;
    private String location;
    private Long userId;
}
