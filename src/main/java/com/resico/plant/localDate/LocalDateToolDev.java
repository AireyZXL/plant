package com.resico.plant.localDate;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @author Airey
 * @since 2022/8/18 10:14
 */
public class LocalDateToolDev {

    public static void main(String[] args) {

        LocalDate date = LocalDate.of(2022, 8, 29);
        long until = LocalDate.now().until(date, ChronoUnit.DAYS);
        System.out.println("until="+until);
        long until1 = date.until(LocalDate.now(), ChronoUnit.DAYS);
        System.out.println("until1="+until1);
    }


}
