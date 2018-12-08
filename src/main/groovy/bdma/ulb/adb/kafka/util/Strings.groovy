package bdma.ulb.adb.kafka.util

import groovy.transform.CompileStatic

/**
 * Created by Ankush on 11/04/17.
 */
@CompileStatic
class Strings {

    static final String EMPTY = ""


    /*
    * Does the String have text?
    * if str == null, then no
    * if str has only whitespace after trimming it, then no
    * Otherwise, hell yes!
    * */
    static boolean hasText(String str) {
        if(!str){
            return false
        }
        def length = str.length()
        for(int i = 0 ; i < length ; i++) {
            if(!Character.isWhitespace(str.charAt(i))) {
                return true
            }
        }
        return false
    }

    /*
    * Don't like using StringBuilder everywhere as it can look verbose.
    * Instead, in order to build a bigger string from smaller strings, just pass the strings as varargs to this method
    * For the array of Objects that are passed, this method would go through each one by one and concat the string returned by the
     * class's toString() method.
    * */
     static  String build( Object... args) {
        Assert.notNull(args,"args cannot be null")
        def sb = new StringBuilder()
        args.each{ arg ->
            sb.append(arg)
        }
        sb.toString()
    }

}
