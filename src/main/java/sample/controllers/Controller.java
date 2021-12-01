package sample.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sample.services.KafkaService;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/kafka/clusters")
@AllArgsConstructor
public class Controller {
    private KafkaService kafkaService;

    @ApiOperation(value = "카프카 토픽 생성")
    @PostMapping("/{clusterId}/topics")
    public void createTopic(@PathVariable String clusterId,
                              @RequestParam String topicName,@RequestParam int numPartitions,
                              @RequestParam short replicationFactor) throws ExecutionException, InterruptedException {
        kafkaService.createTopic(topicName, numPartitions, replicationFactor);
    }

    @ApiOperation(value = "카프카 목록 조회")
    @GetMapping("/{clusterId}/topics")
    public void listTopics(@PathVariable String clusterId) throws ExecutionException, InterruptedException {
        kafkaService.listTopic();
    }

    @ApiOperation(value = "카프카 토픽 조회")
    @GetMapping("/{clusterId}/topics/{topicName}")
    public void describeTopic(){
        
    }
}
