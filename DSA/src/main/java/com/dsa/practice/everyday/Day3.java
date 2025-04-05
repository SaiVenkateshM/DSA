package com.dsa.practice.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
1. Container with Most water (using 2 pointer)
2. 3 sum zero ( 2 pointer)
 */
public class Day3 {
    public static void main(String[] args) {
        int[] A = {1, 5, 4, 3};
        int answer = containerWithMostWater(A);
        System.out.println(answer);
        ArrayList<Integer> givenproblem = new ArrayList<>(Arrays.asList(-1, 0, 1, 2, -1, 4));
        ArrayList<ArrayList<Integer>> ans = sumZero(givenproblem);
    }

    public static int containerWithMostWater(int[] A){
        int len = A.length;

        int answer=0;
        int sum=0;
        int l=0;
        int r=len-1;
        while(l<r){
            sum = Math.min(A[l], A[r]);
            int i = sum * (r - l);
            answer = Math.max(answer,i);
            if(A[l] <= A[r]){
                l++;
            }else{
                r--;
            }
        }
        return answer;
    }

    public static ArrayList<ArrayList<Integer>> sumZero(ArrayList<Integer> A){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        if(A == null){
            return ans;
        }
        Collections.sort(A);
        int n = A.size();
        for(int i=0;i<n-2;i++){
            int j = i+1;
            int k = n-1;
            int sum = -A.get(i);
            if(i>0 && A.get(i).intValue() == A.get(i-1).intValue()) // check for the duplicate value
                continue;
            while (j<k){
                int num = A.get(j) + A.get(k);
                if (num == sum) {
                    temp.add(A.get(i));
                    temp.add(A.get(j));
                    temp.add(A.get(j));
                    ans.add(temp);
                    temp.clear();
                    int prev = j;
                    while (j <= k && A.get(j).intValue() == A.get(prev).intValue()) {
                        j++;
                    }
                }else if(sum < num){
                        j++;
                    }
                    else{
                        k--;
                    }
                }
        }
        return ans;
    }

}
