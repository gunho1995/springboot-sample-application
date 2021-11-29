package sample.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sample.services.KafkaService;

@RestController
@RequestMapping("/kafka/clusters")
@AllArgsConstructor
public class Controller {
    @ApiOperation(value = "카프카 토픽 생성")
    @PostMapping("/{clusterId}/topics")
    public void createTopic(@PathVariable String clusterId,
                              @RequestParam String topicName,@RequestParam int numPartitions,
                              @RequestParam short replicationFactor){
        kafkaService.createTopic(topicName, numPartitions, replicationFactor);
    }
}
