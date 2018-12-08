package bdma.ulb.adb.kafka.domain

class Constants {

    static final Set<Integer> CAMPAIGN_IDS = [1,2,3,4,5,6,7,8,9,10]
    static final Set<Integer> PUB_IDS = [11,12,13,15]

    static final Set<String> CITIES = ["Brussels", "New Delhi", "Barcelona", "Berlin", "Pereira"].toSet()

    static final Map<String, String> COUNTRIES = [
            "Brussels" : "Belgium",
            "New Delhi" : "India",
            "Barcelona" : "Spain",
            "Berlin" : "Germany",
            "Pereira" : "Colombia"
    ]


    static final Set<String> BROWSERS = ["Chrome", "Opera"].toSet()
    static final Set<String> PLATFORM = ["iOS", "Android"].toSet()
    static final Set<String> PLATFORM_VERSION = ["5", "6", "11", "12"].toSet()


}
