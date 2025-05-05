package com.dsa.practice.everyday;

import java.util.ArrayList;
import java.util.Arrays;
/*
1. sliding window
2. contribution array formula - (i+1)*(n-i)
 */
public class Day33 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 1, 3, 4, 5));
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3));
        int size = 5;
        int givenSum = 12;
        int ans = maxSubarraySum(size,givenSum,list);
        Long sumOfSubarrays = subarraySum(list1);
        System.out.println(ans);
        System.out.println(sumOfSubarrays);


    }

    public static int maxSubarraySum(int size,int givenSum,ArrayList<Integer> list) {

        int ans = 0;
        for (int i = 0; i < size; i++) {
            int sum =0;
            for(int j =i;j< size;j++){
                sum += list.get(j);
                if(sum <= givenSum)
                    ans = Math.max(ans,sum);
                else
                    break;
            }
        }
        return ans;
    }

    public static Long subarraySum(ArrayList<Integer> list){
        Long ans= 0L;
        int n = list.size();

        for(int i=0;i<n;i++){
            long numberoftimesElementCame = ((i+1)*(n-i));
            ans += list.get(i) * numberoftimesElementCame;
        }

        return ans;
    }
}
