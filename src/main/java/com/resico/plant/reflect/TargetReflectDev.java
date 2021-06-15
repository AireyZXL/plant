package com.resico.plant.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Airey
 * @date 2021/4/16 15:19
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
public class TargetReflectDev {


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

        Class<?> targetClass = Class.forName("com.resico.plant.reflect.TargetDev");
        TargetDev targetDev = (TargetDev) targetClass.newInstance();


        Method[] declaredMethods = targetClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method.getName());
        }

        Method publicMethod = targetClass.getDeclaredMethod("publicMethod", String.class);
        publicMethod.invoke(targetDev,"JavaGuide");


        Field field = targetClass.getDeclaredField("value");
        //为了对类中的参数进行修改我们取消安全检查
        field.setAccessible(true);
        field.set(targetDev,"JavaGuide");

        Method privateMethod = targetClass.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);
        privateMethod.invoke(targetDev);


    }

}
