package com.resico.plant.reflect;

/**
 * @author Airey
 * @date 2021/4/16 15:05
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
public class TargetDev {


    private String value;

    public TargetDev() {
        value = "JavaGuide";
    }

    public void publicMethod(String s) {
        System.out.println("I love " + s);
    }

    private void privateMethod() {
        System.out.println("value is " + value);
    }


}
