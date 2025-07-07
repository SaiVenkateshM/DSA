package com.dsa.practice.everyday;
/*
DP Famous Problem
1. Longest Increasing Subsequences.

 */
public class Day22 {
    public static void main(String[] args) {
        int[] A = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        int answer = lis(A);
        System.out.println(answer);
    }

    public static int lis(int[] A){
        int n = A.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int ans =1;
        for(int i=0;i<n;i++){
            int max =0;
            for(int j=0;j<i;j++){
                if(A[j] < A[i]){
                    max = Integer.max(max,dp[j]);
                }
            }
            dp[i] = 1 + max;
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}
