package com.resico.plant.hutool;

import java.math.BigDecimal;

/**
 * @author Airey
 * @date 2020/11/26 9:50
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
public class BigDecimalDevT {


    public static void main(String[] args) {

        BigDecimal bigDecimal=BigDecimal.TEN;
        System.out.println(bigDecimal);

        BigDecimal b1=new BigDecimal("1820.12");
        BigDecimal b2=new BigDecimal("0.001");

        BigDecimal multiply = b1.multiply(b2);
        System.out.println(multiply);


    }

}
