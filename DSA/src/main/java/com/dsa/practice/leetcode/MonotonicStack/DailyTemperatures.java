package com.dsa.practice.leetcode.MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        DailyTemperatures dt = new DailyTemperatures();

        System.out.println(Arrays.toString(dt.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73}))); // [1,1,4,2,1,1,0,0]
        System.out.println(Arrays.toString(dt.dailyTemperatures(new int[]{30,40,50,60})));             // [1,1,1,0]
        System.out.println(Arrays.toString(dt.dailyTemperatures(new int[]{30,60,90})));                // [1,1,0]
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>(); // stores indices

        for (int i = 0; i < n; i++) {
            // Pop all previous indices with temperature less than current
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex;
            }
            // Push current index onto the stack
            stack.push(i);
        }

        // Remaining indices will have 0 as default value
        return answer;
    }
}
