package ApacheKafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    public NewTopic createKafkaTopic(String topicName) {
        return TopicBuilder.name(topicName).build();
    }
}
