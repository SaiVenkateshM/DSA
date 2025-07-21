package com.dsa.practice.leetcode.backtracking;

import java.util.ArrayList;

public class PrintAllMaze {
    public static void main(String[] args) {
        int A = 4;
        int B = 3;
        ArrayList<String> ans = printAllPaths(A,B);
        System.out.println(ans);
    }

    public static ArrayList<String> printAllPaths(int row,int column){
        ArrayList<String> ans = new ArrayList<>();
        backtrack(row-1,column-1,"",ans);
        return ans;
    }
    public static void backtrack(int row,int col,String currentString,ArrayList<String> ans){
        if (row == 0 && col == 0) {
            ans.add(currentString);
            return;
        }

        if (row > 0) {
            backtrack(row - 1, col, currentString + 'D', ans);
        }
        if (col > 0) {
            backtrack(row, col - 1, currentString + 'R', ans);
        }
    }
}
