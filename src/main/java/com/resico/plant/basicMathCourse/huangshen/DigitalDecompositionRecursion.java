package com.resico.plant.basicMathCourse.huangshen;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Airey
 * @date 2021/6/15 16:15
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
public class DigitalDecompositionRecursion {


    public static void main(String[] args) {

        divice(8, new ArrayList<>());

    }

    public static void divice(long total, ArrayList<Long> result) {

        if (total == 1) {
            if (!result.contains(1L)) {
                result.add(1L);
            }
            System.out.println(result);
            return;
        } else {
            for (long i = 1; i <= total; i++) {
                if (i == 1 && result.contains(i)) {
                    continue;
                }
                ArrayList<Long> newResult = (ArrayList<Long>) result.clone();
                newResult.add(i);
                if (total % i != 0) {
                    continue;
                }
                divice(total / i, newResult);
            }
        }


    }

}
