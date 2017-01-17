package com.honeybin.sketchu;

import org.joda.time.DateTime;
import org.joda.time.Duration;

/**
 * Created by Anthony Kim on 1/17/2017.
 */

public class TimeHelper {
    private static DateTime dateTime = new DateTime();

    public static String getCurrentTimeString(){
        return DateTime.now().toString();
    }
    public static long findTimeDiff(String original, String current){
        DateTime orig = DateTime.parse(original);
        DateTime now = DateTime.parse(current);
        Duration duration = new Duration(orig, now);
        //this part should be getStandardMinutes() for actual production
        return duration.getStandardSeconds();
    }
}
