package com.dsa.practice.everyday;

import java.util.Arrays;

public class Day21 {
    public static void main(String[] args) {
        String A = "Anshuman";
        String B = "Antihuman";
        int answer = minDistance(A,B);
        System.out.println(answer);
    }

    public static int minDistance(String A, String B){
        int i = A.length();
        int j = B.length();
        int[][] dp = new int[i + 1][j + 1];

        for (int k = 0; k <= i; k++) {
            Arrays.fill(dp[k], -1);  // Fill all columns in row 'i' with -1
        }

        int answer = minCost(A,B,i-1,j-1,dp);

        return answer;
    }

    public static int minCost(String A,String B,int i,int j,int[][] dp){
        if(i<0 && j< 0)
            return 0;
        else if(i < 0)
            return j + 1;
        else if(j < 0)
            return i + 1;
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(A.charAt(i) == B.charAt(j)){
            dp[i][j] = minCost(A,B,i-1,j-1,dp);
        }else {
            dp[i][j] = Math.min(1+minCost(A,B,i,j-1,dp),Math.min(1 + minCost(A,B,i-1,j,dp),1 + minCost(A,B,i-1,j-1,dp)));
        }
        return dp[i][j];
    }
}
