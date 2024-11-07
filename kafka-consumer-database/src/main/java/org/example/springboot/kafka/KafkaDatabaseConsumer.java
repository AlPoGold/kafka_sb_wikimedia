package org.example.springboot.kafka;

import lombok.AllArgsConstructor;
import org.example.springboot.dto.WikimediaEntity;
import org.example.springboot.repositories.WikimediaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaDatabaseConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
    private WikimediaRepository repository;


    @KafkaListener(
            topics="wikimedia_recentchange",
            groupId="myGroup")
    public void consume (String eventMessage){
        LOGGER.info(String.format("Message received -> %s", eventMessage));

        WikimediaEntity wikimediaEntity = new WikimediaEntity();
        wikimediaEntity.setWikiEventData(eventMessage);
        repository.save(wikimediaEntity);
    }
}
