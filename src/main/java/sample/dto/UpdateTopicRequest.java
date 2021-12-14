package sample.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter(AccessLevel.PROTECTED)
public class UpdateTopicRequest {
    private String topicName;
    private int totalPartitions;
    private Map<String, String> configs;

    @Builder
    public UpdateTopicRequest(String topicName, int totalPartitions, Map<String,String> configs){
        this.topicName = topicName;
        this.totalPartitions = totalPartitions;
        this.configs = configs;
    }
}
