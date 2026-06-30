package dev.jorge.ingestion_service.service;

import dev.jorge.ingestion_service.dto.EnergyUsageDto;
import dev.jorge.kafka.event.EnergyUsageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class IngestionService {

    private static final Logger log = LoggerFactory.getLogger(IngestionService.class);

    private final KafkaTemplate<String, EnergyUsageEvent> kafkaTemplate;

    public IngestionService(KafkaTemplate<String, EnergyUsageEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void ingestEnergyUsage(EnergyUsageDto input) {
        // Convert DTO to Event
        EnergyUsageEvent event = new EnergyUsageEvent(
                input.deviceId(),
                input.energyConsumed(),
                input.timestamp()
        );

        // Send to Kafka Topic
        kafkaTemplate.send("energy-usage", event);
        log.info("Ingested Energy Usage Event: {}", event);
    }
}
