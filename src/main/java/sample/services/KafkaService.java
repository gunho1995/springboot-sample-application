package sample.services;

import lombok.AllArgsConstructor;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.admin.TopicDescription;
import org.apache.kafka.clients.admin.*;
import org.springframework.stereotype.Service;

import java.util.Collections;
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

        public void listTopic(){
        }

        public void describeTopic(){

        }

        public void describeConfigs(){

        }

        public void alterConfigs(){

        }

}
