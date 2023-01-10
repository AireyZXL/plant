package com.resico.plant.hutool;

import cn.hutool.core.collection.CollUtil;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CollUtilDev {


    public static void main(String[] args) {


        HashSet<Long> roleIds = new HashSet<Long>();
        roleIds.add(115L);
        roleIds.add(116L);

//        Set<Long> roleIds = Collections.singleton(115L);


        Set<Long> dbRoleIds=new HashSet<>();
        dbRoleIds.add(115L);


        Collection<Long> subtract = CollUtil.subtract(roleIds, dbRoleIds);
        System.out.println("subtract="+subtract);


    }


}
