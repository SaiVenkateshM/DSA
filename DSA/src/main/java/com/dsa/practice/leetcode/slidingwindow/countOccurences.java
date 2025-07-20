package com.dsa.practice.leetcode.slidingwindow;

public class countOccurences {
    public static void main(String[] args) {
        String A = "bobob";
        int ans = solve(A);
        System.out.println(ans);
    }

    public static int solve(String A){
        int ans =0;
        int n = A.length();
        int startIndex = 0;
        int endIndex= 3;
        while(endIndex <= n){
            String sub = A.substring(startIndex,endIndex);
            if(sub.equals("bob")){
                ans++;
            }
            startIndex++;
            endIndex++;
        }
        return ans;
    }
}
