package com.david.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class KafkaConsumer {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 监听kafka.tut 的 topic
     *
     * @param record
     * @param topic  topic
     */
    @KafkaListener(id = "tut", topics = "kafka.tut")
    public void listen(ConsumerRecord<?, ?> record, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        //判断是否NULL
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()) {
            //获取消息
            Object message = kafkaMessage.get();

            logger.info("Receive： +++++++++++++++ Topic:" + topic);
            logger.info("Receive： +++++++++++++++ Record:" + record);
            logger.info("Receive： +++++++++++++++ Message:" + message);
        }
    }
}
