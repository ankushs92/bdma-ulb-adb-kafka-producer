package bdma.ulb.adb.kafka.service

import bdma.ulb.adb.kafka.domain.Click
import bdma.ulb.adb.kafka.domain.KafkaTopics
import bdma.ulb.adb.kafka.util.Assert
import bdma.ulb.adb.kafka.util.Json
import groovy.util.logging.Slf4j
import io.vertx.core.Future
import io.vertx.kafka.client.producer.KafkaProducer
import io.vertx.kafka.client.producer.impl.KafkaProducerRecordImpl
import org.springframework.stereotype.Service

@Service
@Slf4j
class ClickServiceImpl implements ClickService {

    private final KafkaProducer<String, byte[]> kafka

    ClickServiceImpl(KafkaProducer<String, byte[]> kafka) {
        this.kafka = kafka
    }

    @Override
    Future<Void> pushToKafka(Click click) {
        Assert.notNull(click, "click cannot be null")
        def json = Json.encode(click)
        def bytes = json.bytes
        def future = Future.future()
        def record = new KafkaProducerRecordImpl<String, byte[]>(KafkaTopics.CLICK, bytes)
        kafka.write(record, { done ->
            if(done.succeeded()) {
                log.debug "Successfully pushed Click to Kafka"
                future.complete()
            }
            else {
                log.error "Could not push Click event to Kafka. Error {}", done.cause()
            }
        }).exceptionHandler { ex ->
            log.error "", ex
        }
        return future
    }

}
