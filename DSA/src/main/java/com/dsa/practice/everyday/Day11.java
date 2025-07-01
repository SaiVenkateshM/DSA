package com.dsa.practice.everyday;

public class Day11 {
    public static void main(String[] args) {
        int[][] A = {{0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}};
        int answer = uniquePathWithObstacles(A);
        System.out.println(answer);
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
}
