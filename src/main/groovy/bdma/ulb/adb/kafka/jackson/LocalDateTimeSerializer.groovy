package bdma.ulb.adb.kafka.jackson

import bdma.ulb.adb.kafka.util.Strings
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import groovy.util.logging.Slf4j

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


/**
 * Created by Ankush on 03/03/17.
 */
@Slf4j
class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

    @Override
    void serialize( LocalDateTime dateTime,  JsonGenerator jsonGen,  SerializerProvider serProvider)
            throws IOException, JsonProcessingException
    {
        if(dateTime!=null){
            jsonGen.writeString(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(dateTime))
        }
        else{
            log.info("LocalDateTime object was null when serializing LocalDateTime.Using Empty string. ");
            jsonGen.writeString(Strings.EMPTY)
        }
    }
}

