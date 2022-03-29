package com.resico.plant.hutool;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.IdcardUtil;

/**
 * @author Airey
 * @since 2022/3/22 14:11
 */
public class IdNoDev {


    public static void main(String[] args) {

        String idno="652901196611026716";
        int ageByIdCard = IdcardUtil.getAgeByIdCard(idno);
        System.out.println("ageByIdCard="+ageByIdCard);

    }

}
