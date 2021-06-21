package com.resico.plant.basicMathCourse.huangshen;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Airey
 * @date 2021/6/15 16:02
 * ----------------------------------------------
 * 奖励递归问题
 * ----------------------------------------------
 */
public class RewardRecursion {


    public static void main(String[] args) {

        get(15,new ArrayList<>());

    }


    public static void get(long totalReward, ArrayList<Long> result) {
      // 四种面额的纸币
        long[] rewards = {1, 2, 5, 10};
        if (totalReward == 0) {
            System.out.println(result);
            return;
        } else if (totalReward < 0) {
            return;
        } else {
            for (int i = 0; i < rewards.length; i++) {
                ArrayList newResult = (ArrayList) (result.clone());
                newResult.add(rewards[i]);
                get(totalReward - rewards[i], newResult);
            }
        }
    }


}
