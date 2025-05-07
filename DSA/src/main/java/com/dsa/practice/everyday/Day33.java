package com.dsa.practice.everyday;

import java.util.ArrayList;
import java.util.Arrays;
/*
1. basic subarray sum
2. contribution array formula - (i+1)*(n-i)
3. sliding window
Number of subarrays of length k = n-k+1
Total number of subarrays = n*(n+1)/2
Element at index i contributes to (i+1)*(n-i) subarrays
 */
public class Day33 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 1, 3, 4, 5));
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(4, 2, 2, 5, 1));
        int window = 3;
        int sum = 11;
        int answer = slidingwindow(list2,window,sum);
        System.out.println(answer);
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

    public static int slidingwindow(ArrayList<Integer> list,int window,int sum){
        int n = list.size();
        int currentsum=0;
        // create first window
        for(int i=0;i<window;i++){
            currentsum += list.get(i);
        }
        if(currentsum == sum)
            return 1;
        int start =1;
        int end = window ;
        while(end < n){
            currentsum = currentsum - list.get(start - 1) + list.get(end);
            if(currentsum == sum)
                return 1;
            start ++;
            end ++;
        }

        return 0;
    }
}
