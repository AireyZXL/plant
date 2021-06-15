package com.resico.plant.leetcode;

/**
 * @author Airey
 * @date 2021/5/31 15:02
 * ----------------------------------------------
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 16
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：n = 1
 * 输出：true
 *  
 * <p>
 * 提示：
 * <p>
 * -231 <= n <= 231 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-four
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ----------------------------------------------
 */

public class PowerOfFour {

    public static void main(String[] args) {
        PowerOfFour solution = new PowerOfFour();
        boolean powerOfFour = solution.isPowerOfFour(16);
        System.out.println(powerOfFour);
    }


    public boolean isPowerOfFour(int n) {


        while (n > 0) {
            if (n == 1) {
                return true;
            }
            if (n % 4 == 0) {
                n /= 4;
            } else {
                return false;
            }
        }
        return false;
    }


}
