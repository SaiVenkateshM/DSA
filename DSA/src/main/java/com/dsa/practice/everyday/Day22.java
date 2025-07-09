package com.dsa.practice.everyday;
/*
DP Famous Problem
1. Longest Increasing Subsequences.
2. Palindrome Partitioning

 */

public class Day22 {
    /*
    public static void main(String[] args) {
        int[] A = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        int answer = lis(A);
        System.out.println(answer);
        String A1 = "aab";
        //int answer1 = minCut(A);
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

    public static int minCut(String A){
        int n = A.length();
        int[] dp = new int[n];
        int answer = minCuts(A,n-1,dp);

        return answer;
    }

    public static int minCuts(String A,int j,int[] dp){
        if(checkPalindrome(A,0,j) == true){
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for(int cut=j;cut>0;cut--){
           // if(checkPalindrome(A,cut,j) == true){
                 min = Integer.min(min,minCuts(A,cut-1,dp));
            }
        }
        dp[j] = min +1;
        return dp[j];
    }
/*
    public static boolean[][] checkPalindrome(String A, int beginString, int endString){
        int n = A.length();
        boolean[][] dp = new boolean[n][n];

        for(int gap=0;gap<n;gap++){
            for(int i=0,j=gap;j<n;i++,j++){
                if(gap ==0){
                    dp[i][j] = true;
                }else if(gap ==1){
                    dp[i][j] = (A.charAt(i) == A.charAt(j));
                }else{
                   if(A.charAt(i) == A.charAt(j)){
                       dp[i][j] = dp[i+1][j-1];
                   }else{
                       dp[i][j] = false;
                   }
                }
            }
        }
        return dp;
    }

 */
}
