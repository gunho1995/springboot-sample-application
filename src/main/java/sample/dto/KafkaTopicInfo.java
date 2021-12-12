package sample.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Setter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class KafkaTopicInfo {
    private String clusterName;
    private String topicName;
    private int numPartitions;
    private short replicationFactor;
    private Map<String, String> configs;

    @Builder
    public KafkaTopicInfo(String clusterName, String topicName, int numPartitions, short replicationFactor, Map<String, String> configs){
        this.clusterName = clusterName;
        this.topicName = topicName;
        this.numPartitions = numPartitions;
        this.replicationFactor = replicationFactor;
        this.configs = configs;
    }
}
