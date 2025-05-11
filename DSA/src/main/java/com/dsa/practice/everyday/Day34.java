package com.dsa.practice.everyday;

import java.util.ArrayList;
import java.util.Arrays;

/*
1. Good subarray
2. Subarray with least average


 */
public class Day34 {
    public static void main(String[] args) {

        ArrayList<Integer> A1 = new ArrayList<>(Arrays.asList(13, 16, 16, 15, 9, 16, 2, 7, 6, 17, 3, 9));
        int B1 = 65;
        int answer = goodSubarrays(A1,B1);
        System.out.println(answer);
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(20,3,13,5,10,14,8,5,11,9,1,11));
        int B = 9;
        int leastaverageIndex = subarrayLeastAverage(A,B);
        System.out.println(leastaverageIndex);
    }

    public static int goodSubarrays(ArrayList<Integer> A, int B){
        int oddGoodSubarray =0;
        int eventGoodSubarray =0;
        int answer =0;

        for(int i=0;i<A.size();i++){
            int sum =0;
            int subarraylength=0;
            for(int j=i;j<A.size();j++){
                sum += A.get(j);
                subarraylength ++;
                if(sum > B && subarraylength %2 !=0){
                    oddGoodSubarray++;
                }else if(sum < B && subarraylength % 2 == 0){
                    eventGoodSubarray++;
                }
            }
        }
        answer = oddGoodSubarray + eventGoodSubarray;

        return  answer;

    }

    public static int subarrayLeastAverage(ArrayList<Integer> A, int B){
        int n = A.size();
        int ans=0;
        int sum =0;
        for(int i=0;i<B;i++){
            sum += A.get(i);
        }
        int minsum = sum;
         for(int i=B;i<n;i++){
             sum += (A.get(i) - A.get(i-B));
             if(sum < minsum){
                 minsum = sum;
                 ans = (i-B+1);
             }
         }

        return ans;
    }
}
