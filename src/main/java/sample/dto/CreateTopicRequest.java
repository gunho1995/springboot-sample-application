package sample.dto;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class CreateTopicRequest {
    private String topicName;
    private int numPartitions;
    private short replicationFactor;
}
