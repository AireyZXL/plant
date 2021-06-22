package com.resico.plant.leetcode;

/**
 * @author Airey
 * @date 2021/6/21 17:31
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
public class GuessNumbers {


    public static void main(String[] args) {
        Solution solution = new GuessNumbers().new Solution();
        int [] guess={1,2,3};
        int [] answer={3,2,1};
        int game = solution.game(guess, answer);
        System.out.println(game);

    }

    class Solution {
        public int game(int[] guess, int[] answer) {

            int sum=0;
            for (int i = 0; i < guess.length; i++) {
                if (guess[i]==answer[i]){
                    sum++;
                }
            }
           return sum;
        }
    }



}
