package com.resico.plant.collect;

/**
 * @author Airey
 * @date 2021/11/9 10:10
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
public class BooleanTest {


    public static void main(String[] args) {

        boolean serviceFlag = true;
        boolean fromTypeFlag = true;

        test(serviceFlag, fromTypeFlag);


    }

    public static void test(boolean serviceFlag, boolean formTypeFlag) {

        if (serviceFlag && formTypeFlag) {

            System.out.println("all");

        } else if (serviceFlag) {

            System.out.println("service");

        } else if (formTypeFlag) {

            System.out.println("fromType");

        } else {

            System.out.println("111111");
        }

    }

}
