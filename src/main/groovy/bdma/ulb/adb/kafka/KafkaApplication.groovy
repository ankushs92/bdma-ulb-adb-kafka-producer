package bdma.ulb.adb.kafka

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class KafkaApplication {

    static void main(String[] args) {
        SpringApplication.run KafkaApplication, args
    }
}
