package com.vinnilmg.cleanarchitecture.config;

import com.vinnilmg.cleanarchitecture.entrypoint.consumer.message.CustomerMessage;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.Map;

import static org.apache.kafka.clients.CommonClientConfigs.GROUP_ID_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.*;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Value("${vinnilmg.kafka.host}")
    private String kafkaHost;

    @Value("${vinnilmg.kafka.group}")
    private String kafkaGroup;

    @Bean
    public ConsumerFactory<String, CustomerMessage> consumerFactory() {
        Map<String, Object> configProps = Map.of(
                BOOTSTRAP_SERVERS_CONFIG, kafkaHost,
                GROUP_ID_CONFIG, kafkaGroup,
                KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class,
                VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(configProps, new StringDeserializer(), new JsonDeserializer<>(CustomerMessage.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, CustomerMessage> kafkaListenerContainerFactory(
            ConsumerFactory<String, CustomerMessage> consumerFactory
    ) {
        ConcurrentKafkaListenerContainerFactory<String, CustomerMessage> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        return factory;
    }
}
