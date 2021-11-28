package sample.configurations;

import lombok.Getter;
import lombok.Setter;
import org.apache.kafka.clients.admin.AdminClient;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@EnableConfigurationProperties(value = KafkaConfiguration.class)
@EnableAutoConfiguration
public class KafkaConfiguration {
    private List<KafkaCluster> clusters;

    @Getter
    @Setter
    public static class KafkaCluster {
        private String clusterName;
        private String clusterId;
        private List<String> bootstrapServers;
    }
}