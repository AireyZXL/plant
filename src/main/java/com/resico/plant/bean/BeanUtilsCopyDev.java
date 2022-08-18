package com.resico.plant.bean;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;

/**
 * @author Airey
 * @since 2022/8/10 18:06
 */
public class BeanUtilsCopyDev {


    public static void main(String[] args) {


        Person airey = new Person(12, null,null);

        PersonA key = new PersonA();

        key.setAddress("342342342");
        BeanUtil.copyProperties(airey,key,CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));

        System.out.println("key="+key);


    }

}
