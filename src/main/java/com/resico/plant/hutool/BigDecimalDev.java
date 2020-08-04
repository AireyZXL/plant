package com.resico.plant.hutool;

import java.math.BigDecimal;

/**
 * @author Airey
 * @date 2020/8/1 10:30
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
public class BigDecimalDev {

    public static void main(String[] args) {

        BigDecimal MULTIPLE_100 = new BigDecimal(100);
        BigDecimal decimal=new BigDecimal(0.12344);

        BigDecimal multiply = decimal.multiply(MULTIPLE_100);
        System.out.println(multiply);
        System.out.println(1111111);

    }


}
