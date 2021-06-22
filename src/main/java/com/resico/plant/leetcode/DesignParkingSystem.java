package com.resico.plant.leetcode;

/**
 * @author Airey
 * @date 2021/6/21 17:14
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
public class DesignParkingSystem {


    public static void main(String[] args) {

        ParkingSystem solution = new DesignParkingSystem().new ParkingSystem(7,2,0);
        int [] nums={1,2,3,1,1,1,1,2,2,2};
        for (int i = 0; i < nums.length; i++) {
            System.out.println(solution.addCar(nums[i]));
        }

    }

    class ParkingSystem {

        private int big;
        private int medium;
        private int small;

        public ParkingSystem(int big, int medium, int small) {
            this.big = big;
            this.medium = medium;
            this.small = small;
        }

        public ParkingSystem() {

        }

        public boolean addCar(int carType) {

            boolean flag = false;

            switch (carType) {
                case 1:
                    big--;
                    if (big >= 0) {
                        flag =true;
                    }
                    break;
                case 2:
                    medium--;
                    if (medium>=0){
                        flag =true;
                    }
                    break;
                case 3:
                     small--;
                     if (small>=0){
                         flag =true;
                     }
                    break;

                default:
                    break;
            }

            return flag;

        }
    }

}
