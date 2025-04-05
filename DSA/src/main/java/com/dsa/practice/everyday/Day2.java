package com.dsa.practice.everyday;

import java.util.Arrays;

/*
1. Subarray with given sum. - 2 pointer
2.
 */
public class Day2 {
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5};
        int B = 5;
        int[] solve = continuousSum(A,B);
    }


    public static int[] continuousSum(int[] A, int B){
        int len = A.length;
        int leftPointer = 0;
        int rightPointer =0;
        int sum =A[leftPointer];
        while(rightPointer < len){
            if(sum <B){
                rightPointer++;
                if(rightPointer < len){
                    sum += A[rightPointer];
                }
            }else if(sum == B){
                return Arrays.copyOfRange(A,leftPointer,rightPointer);
            }else{
                sum -=A[leftPointer];
                leftPointer++;
            }
        }
        return new int[]{-1};
    }
}
