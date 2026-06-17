package dev.jorge.device_service.controller;

import dev.jorge.device_service.dto.DeviceDto;
import dev.jorge.device_service.service.DeviceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/device")
public class DeviceController {

    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService){
        this.deviceService = deviceService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeviceDto> getDeviceById(@PathVariable Long id){
        DeviceDto device = deviceService.getDeviceById(id);
        return ResponseEntity.ok(device);
    }

    @PostMapping()
    public ResponseEntity<DeviceDto> createDevice(@RequestBody DeviceDto deviceDto){
        DeviceDto createdDevice = deviceService.createDevice(deviceDto);
        return ResponseEntity.ok(createdDevice);

    }

    @PutMapping("/{id}")
    public ResponseEntity<DeviceDto> updateDevice(@PathVariable Long id, @RequestBody DeviceDto deviceDto){
        DeviceDto updateDevice = deviceService.updateDevice(id, deviceDto);
        return ResponseEntity.ok(updateDevice);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeviceDto> deleteDevice(@PathVariable Long id){
        deviceService.deleteDevice(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<DeviceDto>> getAllDevicesByUserId(@PathVariable Long userId){
        List<DeviceDto> device = deviceService.getAllDevicesByUserId(userId);
        return ResponseEntity.ok(device);
    }

}
