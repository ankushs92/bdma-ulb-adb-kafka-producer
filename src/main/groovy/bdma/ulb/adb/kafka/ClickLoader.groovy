package bdma.ulb.adb.kafka

import bdma.ulb.adb.kafka.domain.Click
import bdma.ulb.adb.kafka.domain.Constants
import bdma.ulb.adb.kafka.service.ClickService
import bdma.ulb.adb.kafka.util.IPUtil
import groovy.util.logging.Slf4j
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

import java.time.LocalDateTime

import static bdma.ulb.adb.kafka.domain.Constants.*

@Component
@Slf4j
class ClickLoader {

    private final ClickService clickService

    ClickLoader(ClickService clickService) {
        this.clickService = clickService
    }

    @Scheduled(fixedRate = 1L)
    void generateFakeClicks() {
        log.info "Generating clicks"
        CAMPAIGN_IDS.each { campaignId ->
            PUB_IDS.each { pubId ->
                def uuid = UUID.randomUUID()
                def ip = IPUtil.generateRandomIp()
                def city = getRandom(CITIES)
                def country = COUNTRIES[city]
                def platform = getRandom(PLATFORM)
                def platformVer = getRandom(PLATFORM_VERSION)
                def browser = getRandom(BROWSERS)
                def click = new Click(
                        uid : uuid,
                        timestamp : LocalDateTime.now(),
                        campaignId : campaignId,
                        pubId : pubId,
                        ip : ip,
                        country : country,
                        city : city,
                        platform : platform,
                        platformVer : platformVer,
                        browser : browser
                )
                log.debug "Click {}" , click
                clickService.pushToKafka(click)
            }
        }
    }


    private static String getRandom(Set<String> countries) {
        int r = (int) (Math.random() * (countries.size()))
        countries[r]
    }

    public static void main(String[] args) {
        getRandom(CITIES)
    }
}
