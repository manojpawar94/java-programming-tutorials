package org.mp.java.java8.example.datetimeapi;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * change in the Java 8 date time API is that date and time is now no longer
 * represented by a single number of milliseconds since Jan. 1st 1970, but by
 * the number of seconds and nanoseconds since Jan. 1st 1970. The number of
 * seconds can be both positive and negative and is represented by a long. The
 * number of nanoseconds is always positive and is represented by an int. You
 * will see this new date and time representation in many of the classes in the
 * new Java date time API.
 */
public class DateTimeApiExample {

    public static void main(String[] args) {
        /**
         * Instant:- Represents an instant in time on the time line. In the Java 7 date
         * time API an instant was typically represented by a number of millseconds
         * since Jan. 1st. 1970. In Java 8 the Instant class represents an instant in
         * time represented by a number of seconds and a number of nanoseconds since
         * Jan. 1st 1970.
         */
        Instant instant = Instant.now();

        System.out.println("Instant.now(): " + instant);

        /**
         * An Instant object contains two fields internally which holds the time
         * represented by the Instant: 1. Seconds since the epoch which can be access by
         * getEpochSecond() 2. Nanoseconds which can be access by getNano()
         */
        System.out.println("Epoch Seconds of instant: " + instant.getEpochSecond());
        System.out.println("Nano Seconds of instant " + instant.getNano());

        /**
         * Instant Calculations The Instant class also has several methods which can be
         * used to make calculations relative to an Instant. Some (not all) of these
         * methods are: plusSeconds(),plusMillis(), plusNanos(), minusSeconds(),
         * minusMillis() and minusNanos()
         */

        Instant afterAddingSeconds = instant.plusSeconds(60);
        System.out.println("After adding 60 seconds to instant: " + afterAddingSeconds);

        Instant afterMinusSeconds = afterAddingSeconds.minusSeconds(40);
        System.out.println("After minus 40 seconds to instant: " + afterMinusSeconds);

        Instant afterAddingOneDay = afterMinusSeconds.plus(1, ChronoUnit.DAYS);
        System.out.println("After adding 1 day to instant: " + afterAddingOneDay);

    }

}
/**
--------------------------------------------------------------------
 * Output: 
--------------------------------------------------------------------
Instant.now(): 2020-01-04T17:32:44.261790Z
Epoch Seconds of instant: 1578159164
Nano Seconds of instant 261790000
After adding 60 seconds to instant: 2020-01-04T17:33:44.261790Z
After minus 40 seconds to instant: 2020-01-04T17:33:04.261790Z
After adding 1 day to instant: 2020-01-05T17:33:04.261790Z
--------------------------------------------------------------------
 */