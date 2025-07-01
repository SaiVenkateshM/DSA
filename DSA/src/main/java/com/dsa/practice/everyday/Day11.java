package com.dsa.practice.everyday;

import java.util.Arrays;

/*
1. unique path in the grid.
2. Max Sum Without Adjacent Elements
 */
public class Day11 {
    public static void main(String[] args) {
        int[][] A = {{0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}};
        int answer = uniquePathWithObstacles(A);
        System.out.println(answer);
        int[][] B = {{1, 2, 3, 4},
                {2, 3, 4, 5}};
        int maxanswer = maxAdjacentElements(B);
        System.out.println("2 ->" + maxanswer);
    }

    public static int uniquePathWithObstacles(int[][] A){

        int n = A.length;
        int m = A[0].length;
        // initialize dp
        int[][] dp = new int[n][m];
        if(A[0][0] == 1) return 0;
        dp[0][0] = 1;
        // first fill the column
        for(int i=1;i<n;i++){
            if(A[i][0] == 0){
                dp[i][0] = dp[i-1][0];
            }
        }
        // now fill the row
        for(int j=1;j<m;j++){
            if(A[0][j] == 0){
                dp[0][j] = dp[0][j-1];
            }
        }
        // finally fill the complete dp array
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(A[i][j] == 0){ // this path is unblocked
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[n-1][m-1];
    }

    public static int maxAdjacentElements(int[][] A){
            int n =2; // mentioned in the question.
            int m = A[0].length;
            int[] B = new int[m];
            // Converting 2d array to 1d array.
            for(int i=0;i<m;i++){
                B[i] = Math.max(A[0][i], A[1][i]);
            }
            int[] dp = new int[m];
            Arrays.fill(dp,-1);
            int ans = maxSum(B,m-1,dp);

            return ans;
        }

        public static int maxSum(int[] arr,int idx, int[]dp){
            // base condition for recursion
            if(idx < 0){
                return 0;
            }
            if(dp[idx] != -1)
                return dp[idx];
            int f1 = 0 + maxSum(arr,idx-1,dp);
            int f2 = arr[idx] + maxSum(arr,idx-2,dp);

            dp[idx] = Math.max(f1,f2);
        return dp[idx];
    }
}
