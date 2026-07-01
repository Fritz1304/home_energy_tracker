package dev.jorge.device_service;

import dev.jorge.device_service.dto.DeviceDto;
import dev.jorge.device_service.entity.Device;
import dev.jorge.device_service.model.DeviceType;
import dev.jorge.device_service.repository.DeviceRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class DeviceServiceApplicationTests {

	private static final int NUMBER_OF_DEVICES = 200;
	private static final int USERS = 10;
	@Autowired
	private DeviceRepository deviceRepository;
	@Test
	void contextLoads() {
	}

	@Disabled
	@Test
	void createDevices() {
		for (int i = 1; i <= NUMBER_OF_DEVICES; i++) {
			var device = Device.builder()
					.name("Device" + i)
					.type(DeviceType.values()[i % DeviceType.values().length])
					.location("Location" + ((i % 3) + 1))
					.userId((long) ((i % USERS) + 1))
					.build();
			deviceRepository.save(device);
		}
		log.info("Device Repository has been populated");
	}

}
