package bdma.ulb.adb.kafka.service

import bdma.ulb.adb.kafka.domain.Click
import io.vertx.core.Future

interface ClickService {

    Future<Void> pushToKafka(Click click)

}
