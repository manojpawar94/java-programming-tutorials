package org.mp.java.java8;

import java.time.Duration;
import java.time.Instant;

public class DateTimeApiExample2 {

    public static void main(String[] args) {
        /**
         * Duration:- Represents a duration of time, for instance the time between two
         * instants. Like the Instant class a Duration represents its time as a number
         * of seconds and nanoseconds. A Duration instance is immutable so once it is
         * created you cannot change its values. You can, however, create new Duration
         * objects based on another Duration object via calculation methods.
         */
        Instant startInstant = Instant.now();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Instant endInstant = Instant.now();

        Duration duration = Duration.between(startInstant, endInstant);
        System.out.println("Start Instant: " + startInstant);
        System.out.println("End Instant: " + endInstant);
        System.out.println("Duration of process: " + duration);

        System.out.println("Duration in minutes: " + duration.toMinutes());
        System.out.println("Duration in seconds: " + duration.getSeconds());
        System.out.println("Duration in Nano seconds: " + duration.getNano());

        /**
         * The Duration class contains a set of methods you can use to perform
         * calculations based on a Duration object. Some of these methods are:
         * plusNanos(), plusMillis(), plusSeconds(), plusMinutes(), plusHours(),
         * plusDays(), minusNanos(), minusMillis(), minusSeconds(), minusMinutes(),
         * minusHours() and minusDays()
         */
        Duration timer = Duration.ofSeconds(3);
        System.out.println("Timer started for 3 seconds...");
        while (!timer.isZero()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(timer.getSeconds());
            timer = timer.minusSeconds(1);
        }
        System.out.println("Timer completed...");

    }
}

/**
--------------------------------------------------------------------
 * Output: 
-------------------------------------------------------------------- 
Start Instant: 2020-01-04T18:00:55.939289Z
End Instant: 2020-01-04T18:00:57.944562Z
Duration of process: PT2.005273S
Duration in minutes: 0
Duration in seconds: 2
Duration in Nano seconds: 5273000
Timer started for 3 seconds...
3
2
1
Timer completed...
--------------------------------------------------------------------
 */