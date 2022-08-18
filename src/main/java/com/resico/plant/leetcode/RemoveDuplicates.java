package com.resico.plant.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Airey
 * @since 2022/6/14 16:06
 * 删除有序数组中的重复项
 */
public class RemoveDuplicates {
    public static void main(String[] args) {

        int[] nums = new int[]{-3,-1,0,0,0,3,3};
        int i = removeDuplicates(nums);
        System.out.println(i + ",nums =" + Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int k : nums) {
            set.add(k);
        }

        ArrayList<Integer> list = new ArrayList<>(set);
        for (int i = 0; i < set.size(); i++) {
            nums[i] = list.get(i);
        }

        Arrays.sort(nums);

        return set.size();
    }
}
