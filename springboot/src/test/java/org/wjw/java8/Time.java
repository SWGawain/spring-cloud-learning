package org.wjw.java8;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.locks.Lock;

/**
 * Created by SWGawain on 2017/5/17.
 */
public class Time {

    @Test
    public void testInstant(){
        Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                .withLocale(Locale.UK)
                .withZone(ZoneId.systemDefault());
        String format = formatter.format(instant);
        System.out.println(format);
    }

    @Test
    public void testClock(){

        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock.millis());
        System.out.println(System.currentTimeMillis());
        System.out.println(clock.instant());
        System.out.println(clock.getZone());
        System.out.println(clock);

        LocalDate localDate = LocalDate.now(clock);
        LocalTime localTime = LocalTime.now(clock);

        System.out.println(localDate);
        System.out.println(localTime);

    }

    @Test
    public void testClock2(){
        Instant instant = Instant.ofEpochMilli(1496332800000l);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM月dd日")
                .withLocale(Locale.UK).withZone(ZoneId.systemDefault());

        String format = formatter.format(instant);
        System.out.println(format);

    }

}
