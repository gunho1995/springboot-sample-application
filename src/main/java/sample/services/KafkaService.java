package sample.services;

import lombok.AllArgsConstructor;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.admin.TopicDescription;
import org.apache.kafka.clients.admin.*;
import org.apache.kafka.common.config.ConfigResource;
import org.apache.kafka.common.config.TopicConfig;
import org.apache.kafka.common.requests.DeleteTopicsRequest;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ExecutionException;

@Service
@AllArgsConstructor
public class KafkaService {

    private AdminClient adminClient;

        public void createTopic(String topicName, int numPartitions, short replicationFactor) throws ExecutionException, InterruptedException {
            NewTopic newTopic = new NewTopic(topicName, numPartitions, replicationFactor);
            CreateTopicsResult createTopicsResult = adminClient.createTopics(Collections.singleton(newTopic));
            createTopicsResult.all().get();
        }

        public void listTopic() throws ExecutionException, InterruptedException {
            ListTopicsResult listTopicsResult = adminClient.listTopics();
            listTopicsResult.listings().get();
        }

        public void describeTopic() throws ExecutionException, InterruptedException {
            DescribeTopicsResult describeTopicsResult = adminClient.describeTopics(Collections.singleton("crispy"));
            describeTopicsResult.all().get();
        }

        public void describeConfigs(){
            ConfigResource configResource = new ConfigResource(ConfigResource.Type.TOPIC, "crispy");
            DescribeConfigsResult describeConfigsResult = adminClient.describeConfigs(
                    Collections.singleton(configResource));
        }

        public void alterConfigs() throws ExecutionException, InterruptedException {
            ConfigResource configResource = new ConfigResource(ConfigResource.Type.TOPIC, "crispy");
            List<ConfigEntry> configEntries = new ArrayList<>();
            Config config = new Config(configEntries);

            Map<ConfigResource, Config> configuration = new HashMap<>();
            AlterConfigsResult alterConfigsResult = adminClient.alterConfigs(
                    Collections.singletonMap(configResource, config)
            );
            alterConfigsResult.all().get();
        }

        public void deleteTopic(){
            adminClient.deleteTopics(Collections.singleton("crispy"));
        }

}
