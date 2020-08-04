package com.resico.plant.date;

import java.time.LocalDate;

/**
 * @author Airey
 * @date 2020/8/4 15:17
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
public class LocalDateDev {

    public static void main(String[] args) {


        String s = LocalDate.now().toString().replace("-", "");
        System.out.println(s);


    }

}
