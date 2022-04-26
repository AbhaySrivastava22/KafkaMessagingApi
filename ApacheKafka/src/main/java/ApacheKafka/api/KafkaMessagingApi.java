package ApacheKafka.api;

import ApacheKafka.model.MessageRequest;
import ApacheKafka.model.NewChatModel;
import ApacheKafka.producer.KafkaMessageProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafkamessagingapi/v1/messages/")
public class KafkaMessagingApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMessagingApi.class);
    private KafkaMessageProducer kafkaProducer;

    public KafkaMessagingApi(KafkaMessageProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/getmessage/")
    public ResponseEntity<String> publishMessage(@RequestBody MessageRequest request) {
        try {
            String ack = kafkaProducer.messageProducer(request);
            return ResponseEntity.ok(ack);
        } catch (Exception exception) {
            LOGGER.error("KafkaMessagingApi:", "Exception Occurred:", exception);
            throw exception;
        }
    }

    @PostMapping("/startnewchat/")
    public ResponseEntity<String> publishNewChat(@RequestBody NewChatModel newChatModel) {
        try {
            String ack = kafkaProducer.newChatProducer(newChatModel);
            return ResponseEntity.ok(ack);
        } catch (Exception exception) {
            LOGGER.error("KafkaMessagingApi:", "Exception Occurred:", exception);
            throw exception;
        }
    }

}
