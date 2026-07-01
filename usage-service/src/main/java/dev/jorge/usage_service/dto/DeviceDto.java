package dev.jorge.usage_service.dto;

import lombok.Builder;

@Builder
public record DeviceDto(Long id,
                        String name,
                        String type,
                        String location,
                        Long userId,
                        Double energyConsumed) {
}