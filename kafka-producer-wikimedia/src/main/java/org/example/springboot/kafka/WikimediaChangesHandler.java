package org.example.springboot.kafka;


import com.launchdarkly.eventsource.MessageEvent;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import lombok.AllArgsConstructor;
import org.apache.kafka.common.protocol.types.Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;


@AllArgsConstructor
public class WikimediaChangesHandler implements BackgroundEventHandler {

    private KafkaTemplate<String, String> kafkaTemplate;
    private String topic;

    private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaChangesProducer.class);
    @Override
    public void onOpen() throws Exception {

    }

    @Override
    public void onClosed() throws Exception {

    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
        LOGGER.info(String.format("event -> %s", messageEvent.getData()));

        kafkaTemplate.send(topic,messageEvent.getData());
    }

    @Override
    public void onComment(String s) throws Exception {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
