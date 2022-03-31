package com.resico.plant.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

/**
 * @author Airey
 * @since 2022/3/2 16:08
 */
public class LocalDateTimeDev {


    public static void main(String[] args) {


        LocalDateTime now = LocalDateTime.now();

        System.out.println("now="+now);

        LocalDateTime localDateTime1 = now.minusMonths(6);
        System.out.println("localDateTime1 = "+localDateTime1);

        LocalDate date=LocalDate.now();


        LocalDate endDate = date.minusMonths(6);
        System.out.println("endDate="+endDate);


        LocalDateTime localDateTime = Optional.ofNullable(date).map(LocalDate::atStartOfDay).orElse(null);
        System.out.println("localDateTime="+localDateTime);

        LocalDateTime end = Optional.ofNullable(date).map(item -> LocalDateTime.of(item, LocalTime.MAX)).orElse(null);
        System.out.println("end="+end);


    }
}
