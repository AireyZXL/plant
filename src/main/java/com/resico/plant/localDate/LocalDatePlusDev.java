package com.resico.plant.localDate;

import java.time.LocalDate;

/**
 * @author Airey
 * @since 2022/7/28 17:30
 */
public class LocalDatePlusDev {
    public static void main(String[] args) {

        LocalDate now = LocalDate.of(2022,7,1);
        LocalDate date = now.plusMonths(12).minusDays(1);
        System.out.println("date="+date);

        boolean b = LocalDate.now().isAfter(now) && LocalDate.now().isBefore(date);
        System.out.println("b="+b);


    }
}

