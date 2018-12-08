package bdma.ulb.adb.kafka.domain

import bdma.ulb.adb.kafka.jackson.LocalDateTimeSerializer
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import groovy.transform.ToString

import java.time.LocalDateTime

@ToString(includeNames = true)
class Click {

    @JsonProperty("uid")
    final UUID uid

    @JsonSerialize(using = LocalDateTimeSerializer)
    @JsonProperty("timestamp")
    final LocalDateTime timestamp

    @JsonProperty("campaignId")
    final Integer campaignId

    @JsonProperty("pubId")
    final Integer pubId

    @JsonProperty(value="ip")
    final  String ip

    @JsonProperty(value='city',required=false , defaultValue =  '')
    final String city

    @JsonProperty(value='country',required=false , defaultValue =  '')
    final String country

    @JsonProperty(value='browser',required=false , defaultValue =  '')
    final String browser

    @JsonProperty(value='platform',required=false , defaultValue =  '')
    final String platform

    @JsonProperty(value='platformVersion',required=false , defaultValue =  '')
    final String platformVersion

    Click(Map fields) {
        this.uid = fields['uid'] as UUID
        this.campaignId = fields['campaignId'] as Integer
        this.pubId = fields['pubId'] as Integer
        this.ip = fields['ip'] as String
        this.city = fields['city'] as String
        this.country = fields['country'] as String
        this.browser = fields['browser'] as String
        this.platform = fields['platform'] as String
        this.platformVersion = fields['platformVersion'] as String
    }



}
