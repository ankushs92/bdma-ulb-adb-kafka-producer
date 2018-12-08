package bdma.ulb.adb.kafka.util

class IPUtil {

    private static final Random random = new Random()
    static String generateRandomIp() {
         random.nextInt(256) + "." + random.nextInt(256) + "." + random.nextInt(256) + "." + random.nextInt(256)
    }

    public static void main(String[] args) {
        println generateRandomIp()
    }
}
