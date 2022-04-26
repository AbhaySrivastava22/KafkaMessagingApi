package ApacheKafka.consumer;

import ApacheKafka.model.MessageRequest;
import ApacheKafka.producer.ReplySender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Component
public class KafkaConsumerListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerListener.class);

    private ReplySender replySender;

    public KafkaConsumerListener(ReplySender replySender) {
        this.replySender = replySender;
    }

    @KafkaListener(id = "Messaging Api", topicPattern = "message.*", groupId = "My Message Group", containerFactory = "messageFactory")
    void listener(MessageRequest data) {
        System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")) + ": "
                + data.getMessageSenderName() + ": " + data.getMessage());
        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner sc = new Scanner(System.in);
        String mssg = sc.nextLine();
        if (!mssg.equalsIgnoreCase("BYE")) {
            try {
                LOGGER.info("KafkaConsumerListener:", replySender.reply(data, mssg));
            } catch (Exception exception) {
                LOGGER.error("KafkaConsumerListener:", "Exception Occurred:", exception);
                throw exception;
            }
        } else {
            LOGGER.info("Waiting for another message...");
        }
    }
}
