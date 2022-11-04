package com.resico.plant.list;

import com.resico.plant.bean.ZFunds;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Airey
 * @since 2022/9/8 15:26
 */
public class ListSort {


    public static void main(String[] args) {


        ArrayList<ZFunds> fundList = new ArrayList<>();


        ZFunds zFunds2 = new ZFunds();
        zFunds2.setQuarter("1-9月预算");
        fundList.add(zFunds2);

        ZFunds zFunds1 = new ZFunds();
        zFunds1.setQuarter("1-6月预算");
        fundList.add(zFunds1);

        ZFunds zFunds3= new ZFunds();
        zFunds3.setQuarter("1-12月预算");
        fundList.add(zFunds3);

        System.out.println("fundList=" + fundList);


        Collections.sort(fundList);

        System.out.println("fundListsort=" + fundList);





    }


}
