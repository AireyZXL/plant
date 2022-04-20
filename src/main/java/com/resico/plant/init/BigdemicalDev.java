package com.resico.plant.init;

import java.math.BigDecimal;

/**
 * @author Airey
 * @since 2022/4/19 10:17
 */
public class BigdemicalDev {


    public static void main(String[] args) {


        BigDecimal bigDecimal=BigDecimal.valueOf(173.7100056);
        BigDecimal bigDecimal1 = bigDecimal.setScale(2, BigDecimal.ROUND_UP);
        System.out.println(bigDecimal1);


    }


}
