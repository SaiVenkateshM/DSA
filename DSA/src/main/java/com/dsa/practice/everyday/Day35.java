package com.dsa.practice.everyday;

import java.util.ArrayList;
import java.util.Arrays;

/*
1. Counting Subarrays //slidding window approach

 */
public class Day35 {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 11, 2, 3, 15));
        int B = 10;

        int answer = subArrayLessThanB(A,B);
        System.out.println(answer);
    }

    public static int subArrayLessThanB(ArrayList<Integer> A, Integer B){
        int n = A.size();
        int answer = 0;
        int start =0;
        int currentSum =0;

        for(int end=0;end<n;end++){
            currentSum += A.get(end);
            while(currentSum >= B && start <= end){
                currentSum -= A.get(start);
                start++;
            }
            answer += end - start +1;
        }
        return answer;
    }
}
