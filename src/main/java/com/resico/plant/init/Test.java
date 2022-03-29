package com.resico.plant.init;

import cn.hutool.core.util.ObjectUtil;
import org.apache.commons.lang3.StringUtils;

public class Test {

    public static void main(String[] args) {

        System.out.println("Hello!!!");

        String s=new String("");
        boolean notBlank = StringUtils.isNotBlank(s);
        System.out.println(notBlank);
        boolean notNull = ObjectUtil.isNotNull(s);
        System.out.println(notNull);


        Cat cat=new Cat();
        System.out.println(cat);

    }


}
