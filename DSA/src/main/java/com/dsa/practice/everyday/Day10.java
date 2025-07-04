package com.dsa.practice.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
1. Climbing Stairs
2. fibonacci series.
3. Minimum Number of Squares
4. Max Product Subarray - knapsack
 */
public class Day10 {
    public static void main(String[] args) {
        int A2 = 2;
        int answer = climbStairs(A2);
        System.out.println(answer);
       // Scanner sc = new Scanner(System.in);
      //  int A1 = sc.nextInt();
        //System.out.println(fibonacci(A1));
        int A = 6;
        int answerSquare = countMinSquare(A);
        System.out.println(answerSquare);

        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(4, 2, -5, 1));
        int maxProduct = maxProductMethod(B);
        System.out.println(maxProduct);
    }

    public static int climbStairs(int A){
        int[] dp = new int[A+1];
        Arrays.fill(dp,-1);
        int ans = waysToClimb(A,dp);
        return ans;
    }

    public static int waysToClimb(int A, int[] dp){
        int mod = 1000000007;
        if(A <= 1){
            return 1;
        }
        if(dp[A] != -1){
            return dp[A];
        }
        dp[A] = waysToClimb(A-1,dp) % mod  + waysToClimb(A-2,dp) % mod;

        return dp[A];
    }

    public static int fibonacci(int A){
        if( A == 0) return 0;
        if( A == 1) return 1;
        int prev2=0;
        int prev1=1;
        int curr=0;
        for(int i=2;i<=A; i++){
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }

    public static int countMinSquare(int A){
        int[] dp = new int[A+1];
        Arrays.fill(dp,-1);
        int ans = minSquareDP(A,dp);
        return ans;
    }

    public static int minSquareDP(int A,int[] dp){
        if(A ==0){
            return 0;
        }
        if(dp[A] != -1){
            return dp[A];
        }
        int result = Integer.MAX_VALUE;
        for(int i=1;i * i<=A;i++){
            result = Math.min(result,minSquareDP(A - (i * i),dp));
        }
        dp[A] = result +1;
        return dp[A];
    }

    public static int maxProductMethod(List<Integer> A){
       int n= A.size();
       int minProd = A.get(0);
       int maxProd = A.get(0);
       int result = A.get(0);

       for(int i=1;i<n;i++){
           int current = A.get(i);

           if(current <0){
               int temp = maxProd;
               maxProd = minProd;
               minProd = temp;
           }
           maxProd = Math.max(current,current * maxProd);
           minProd = Math.min(current,current * minProd);

           result = Math.max(result,maxProd);
       }
       return result;
    }

}
