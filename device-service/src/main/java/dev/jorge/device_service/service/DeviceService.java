package dev.jorge.device_service.service;

import dev.jorge.device_service.dto.DeviceDto;
import dev.jorge.device_service.entity.Device;
import dev.jorge.device_service.exception.DeviceNotFoundException;
import dev.jorge.device_service.repository.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public DeviceDto getDeviceById(Long id){
        Device device = deviceRepository.findById(id)
                .orElseThrow(()->
                        new IllegalArgumentException("Device not found with id "+id));

        return mapToDto(device);
    }

    private DeviceDto mapToDto(Device device){
        DeviceDto dto = new DeviceDto();
        dto.setId(device.getId());
        dto.setName(device.getName());
        dto.setDeviceType(device.getType());
        dto.setLocation(device.getLocation());
        dto.setUserId(device.getUserId());
        return dto;
    }

    public DeviceDto createDevice(DeviceDto input) {
        Device device = new Device();
        device.setName(input.getName());
        device.setType(input.getDeviceType());
        device.setLocation(input.getLocation());
        device.setUserId(input.getUserId());

        final Device savedDevice = deviceRepository.save(device);
        return mapToDto(savedDevice);
    }
    public DeviceDto updateDevice(Long id, DeviceDto input) {
        Device existing = deviceRepository.findById(id)
                .orElseThrow(() ->
                        new DeviceNotFoundException("Device not found with id " + id));

        existing.setName(input.getName());
        existing.setType(input.getDeviceType());
        existing.setLocation(input.getLocation());
        existing.setUserId(input.getUserId());

        final Device updatedDevice = deviceRepository.save(existing);
        return mapToDto(updatedDevice);
    }
    public void deleteDevice(Long id) {
        if (!deviceRepository.existsById(id)) {
            throw new DeviceNotFoundException("Device not found with id " + id);
        }
        deviceRepository.deleteById(id);
    }

    public List<DeviceDto> getAllDevicesByUserId(Long userId) {
        List<Device> devices = deviceRepository.findAllByUserId(userId);
        return devices.stream()
                .map(this::mapToDto)
                .toList();
    }


}
