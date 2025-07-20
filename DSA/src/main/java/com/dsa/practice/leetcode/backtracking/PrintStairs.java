package com.dsa.practice.leetcode.backtracking;

import java.util.ArrayList;

public class PrintStairs {
    public static void main(String[] args) {
        int A = 2;
        ArrayList<ArrayList<Integer>> ans = waysToClimb(A);
        System.out.println(ans);
    }

    public static ArrayList<ArrayList<Integer>> waysToClimb(int A){
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        ArrayList<Integer> currentPath = new ArrayList<>();
        backtrack(A,0,currentPath,answer);
        return answer;
    }
    public static void backtrack(int finalStep,int currentStep,ArrayList<Integer> currentPath, ArrayList<ArrayList<Integer>> answer){
        if(currentStep == finalStep){
            answer.add(new ArrayList<>(currentPath));
            return ;
        }
        if (currentStep > finalStep) return ;

        currentPath.add(1);
        backtrack(finalStep,currentStep +1,currentPath,answer);
        currentPath.remove(currentPath.size() - 1);

        currentPath.add(2);
        backtrack(finalStep,currentStep +2,currentPath,answer);
        currentPath.remove(currentPath.size() - 1);
    }
}
