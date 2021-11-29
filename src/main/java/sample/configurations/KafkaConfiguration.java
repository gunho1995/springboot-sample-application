package sample.configurations;

import lombok.Getter;
import lombok.Setter;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Properties;

@Configuration
@EnableConfigurationProperties(value = KafkaConfiguration.class)
@EnableAutoConfiguration
public class KafkaConfiguration {
    @ConfigurationProperties("kafka")
    @Getter
    @Setter
    static class KafkaClusterConfiguration {
            private List<KafkaCluster> clusters;
    }

    @Getter
    @Setter
    static class KafkaCluster {
        private String name;
        private String clusterId;
        private List<String> bootstrapServers;
    }

    @Bean
    public AdminClient getKafkaAdminClient(@Autowired KafkaClusterConfiguration kafkaClusterConfiguration){
        List<String> bootstrapServers = kafkaClusterConfiguration.getClusters().get(0).getBootstrapServers();
        Properties props = new Properties();
        props.setProperty(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, String.join(",",bootstrapServers));
        return AdminClient.create(props);
    }
}