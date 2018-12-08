package bdma.ulb.adb.kafka.config
import io.vertx.core.Vertx
import io.vertx.kafka.client.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.ByteArraySerializer
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class KafkaConfig {

    @Autowired
    Vertx vertx


    @Bean("kafka")
    KafkaProducer kafkaProducer() {
        def config = new Properties()
        def host = "localhost:9092"
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,host)
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class)
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class)
        config.put(ProducerConfig.ACKS_CONFIG, "1")

        return KafkaProducer.create(vertx, config)
    }


}
