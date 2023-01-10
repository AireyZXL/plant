package com.resico.plant.stack;

import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class StackDev {


    public static void main(String[] args) {


        push();


    }


    /**
     * 先进后出 -> 先进先出  出队   1,2,3  1,2,3   1,2,3 -> 3,2,1  3,2,1 -> 1,2,3
     *
     * 1,2,3  ->    入栈    出栈  3,2,1  出栈为空 -> 入栈
     */
    public static void push(){

        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        Stack<Integer> st3= new Stack<>();

        st1.push(1);
        st1.push(2);
        st1.push(3);

        System.out.println(st1);
        int size=st1.size();
        for (int i = 0; i < size; i++) {
            Integer pop = st1.pop();
            System.out.println("pop="+pop);
            st2.push(pop);
        }

        int m=st2.size();
        for (int i = 0; i < m; i++) {
            Integer pop2 = st2.pop();
            System.out.println("pop2="+pop2);
            st3.push(pop2);
        }
        System.out.println(st2);

        System.out.println(st3);
    }


    /**
     * 入队
     */
    public static  void peek(){


    }





}
