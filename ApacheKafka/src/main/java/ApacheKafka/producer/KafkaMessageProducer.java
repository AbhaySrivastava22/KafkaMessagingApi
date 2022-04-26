package ApacheKafka.producer;

import ApacheKafka.config.KafkaTopicConfig;
import ApacheKafka.model.MessageRequest;
import ApacheKafka.model.NewChatModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMessageProducer.class);

    private KafkaTemplate<String, MessageRequest> kafkaTemplate;

    private KafkaTopicConfig kafkaTopicConfig;

    public KafkaMessageProducer(KafkaTemplate<String, MessageRequest> kafkaTemplate,
            KafkaTopicConfig kafkaTopicConfig) {
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaTopicConfig = kafkaTopicConfig;
    }

    public String messageProducer(MessageRequest messageRequest) {
        try {
            String topicName = "message." + messageRequest.getMessageRecieverName();
            kafkaTopicConfig.createKafkaTopic(topicName);
            kafkaTemplate.send(topicName, messageRequest);
            LOGGER.info("KafkaProducerListener:", "The Message is Delivered Successfully");
            return "The Message is Delivered Successfully";
        } catch (Exception exception) {
            throw exception;
        }
    }

    public String newChatProducer(NewChatModel newChatModel) {
        try {
            String messageSenderName = "message." + newChatModel.getMessageSenderName();
            kafkaTopicConfig.createKafkaTopic(messageSenderName);
            kafkaTemplate.send(messageSenderName, new MessageRequest());
            String messageRecieverName = "message." + newChatModel.getMessageRecieverName();
            kafkaTemplate.send(messageRecieverName, new MessageRequest());
            kafkaTopicConfig.createKafkaTopic(messageRecieverName);
            LOGGER.info("KafkaProducerListener:", "The New Chat is Established Successfully");
            return "The New Chat is Established Successfully";
        } catch (Exception exception) {
            throw exception;
        }
    }
}
