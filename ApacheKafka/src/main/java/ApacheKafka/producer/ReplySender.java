package ApacheKafka.producer;

import ApacheKafka.consumer.KafkaConsumerListener;
import ApacheKafka.model.MessageRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ReplySender {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerListener.class);

    private KafkaMessageProducer kafkaMessageProducer;

    public ReplySender(KafkaMessageProducer kafkaMessageProducer) {
        this.kafkaMessageProducer = kafkaMessageProducer;
    }

    public String reply(MessageRequest messageRequest, String mssg) {
        try {
            String messageSenderName = messageRequest.getMessageSenderName();
            messageRequest.setMessage(mssg);
            messageRequest.setMessageSenderName(messageRequest.getMessageRecieverName());
            messageRequest.setMessageRecieverName(messageSenderName);
            kafkaMessageProducer.messageProducer(messageRequest);
            return "Reply Sent Successfully";
        } catch (Exception exception) {
            throw exception;
        }

    }
}
