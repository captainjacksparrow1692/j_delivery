package uzumtech.j_delivery.configuration.kafka;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import uzumtech.j_delivery.configuration.props.KafkaProps;
import uzumtech.j_delivery.dto.DlqDto;
import uzumtech.j_delivery.dto.OrderDto;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class ProducerConfiguration {

    KafkaProps kafkaProps;

    private Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();

        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProps.getBootstrapServers());
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.springframework.kafka.support.serializer.JsonSerializer");

        props.put(ProducerConfig.ACKS_CONFIG, "all");
        props.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, true);

        return props;
    }

    // Создаем фабрику с типизацией
    private <T> ProducerFactory<String, T> createProducerFactory() {
        DefaultKafkaProducerFactory<String, T> factory = new DefaultKafkaProducerFactory<>(producerConfigs());
        return factory;
    }

    @Bean("dlqTemplate")
    public KafkaTemplate<String, DlqDto> dlqTemplate() {
        return new KafkaTemplate<>(createProducerFactory());
    }

    @Bean("orderTemplate")
    public KafkaTemplate<String, OrderDto> orderTemplate() {
        return new KafkaTemplate<>(createProducerFactory());
    }
}