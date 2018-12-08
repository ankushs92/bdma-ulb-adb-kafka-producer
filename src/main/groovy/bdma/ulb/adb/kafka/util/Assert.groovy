package bdma.ulb.adb.kafka.util

/**
 * Created by Ankush on 11/04/17.
 */
class Assert {

    static <T> boolean  notNull(T t, String errorMsg){
        if(t == null){
            throw new IllegalArgumentException(errorMsg)
        }
    }

    static boolean nonEmptyString(String str, String errorMsg){
        if(!Strings.hasText(str)){
            throw new IllegalArgumentException(errorMsg)
        }
    }
}
