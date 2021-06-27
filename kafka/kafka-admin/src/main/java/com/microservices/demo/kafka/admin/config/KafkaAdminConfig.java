package com.microservices.demo.kafka.admin.config;

import com.microservices.demo.config.KafkaConfigData;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.admin.AdminClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Properties;

@EnableRetry
@Configuration
public class KafkaAdminConfig {
    private static final Logger LOG = LoggerFactory.getLogger(KafkaAdminConfig.class);

    private final KafkaConfigData kafkaConfigData;

    public KafkaAdminConfig(KafkaConfigData configData) {
        this.kafkaConfigData = configData;
    }

    @Bean
    public AdminClient adminClient() {
        Properties properties = new Properties();
        LOG.info("CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG {}", CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG);
        LOG.info("kafkaConfigData.getBootstrapServers {}", kafkaConfigData.getTopicName());
        properties.put(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG, kafkaConfigData.getBootstrapServers());
        return AdminClient.create(properties);
    }
}
