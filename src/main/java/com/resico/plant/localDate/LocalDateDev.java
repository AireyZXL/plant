package com.resico.plant.localDate;



import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * @author Airey
 * @date 2020/8/4 15:17
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
public class LocalDateDev {

    public static void main(String[] args) {


//        String s = LocalDate.now().toString().replace("-", "");
//        System.out.println(s);
//
//        LocalDate localDate=LocalDate.now();
//        LocalDateTime of = LocalDateTime.of(localDate, LocalTime.parse("00:00:00"));
//        LocalDateTime end = LocalDateTime.of(localDate, LocalTime.parse("23:59:59"));
//        System.out.println(of);
//        System.out.println(end);
//
//
//
//
//        DateTime dt2 = new DateTime("2015-05-20T13:29:35.120+08:00");
//        long millis = dt2.getMillis();
//
//        Date date=new Date(millis);
//        System.out.println("date = "+date);
//        LocalDateTime localDateTime = date.toInstant().atOffset(ZoneOffset.of("+8")).toLocalDateTime();
//        System.out.println("localDateTime="+localDateTime);
//
//
//
//        LocalDate md = LocalDate.now().minusDays(60);
//        System.out.println("md="+md);
//
//
//        LocalDate md3 = LocalDate.now().plusDays(60);
//        System.out.println("md3="+md3);
//
//
//        String dateStr="234234";
//        LocalDate parse = LocalDate.parse(dateStr);
//
//        System.out.println("parse="+parse);
//

        LocalDate date=LocalDate.now();
        LocalDate firstDay = date.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate lastDay = date.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("firstDay="+firstDay);
        System.out.println("lastDay="+lastDay);


    }

}
