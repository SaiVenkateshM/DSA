package com.dsa.practice.everyday;
/*
Questions on recursion and backtracking.
1. sum of digit (recursion)
2. Magic number
3. N Queens
 */

import java.util.ArrayList;
import java.util.List;

public class Day18 {
    public static void main(String[] args) {
        int A = 83557;
        int answer = findSum(A);
        System.out.println(answer);

        int magicAnswer = magicNumber(A);
        System.out.println(magicAnswer);
        int B = 4;
        ArrayList<ArrayList<String>> answerQueen = NQueenSolver(4);
    }

    public static int findSum(int A){
        if(A == 0)
            return 0;

        return (A%10 + findSum(A/10));
    }

    public static int magicNumber(int A){
        if(A < 10){
            return (A == 1) ? 1 : 0;
        }

        int digit_sum = 0;
        while(A>0){
            digit_sum += A % 10;
            A =A/10;
        }
        return magicNumber(digit_sum);
    }

    public static ArrayList<ArrayList<String>> NQueenSolver(int A){
        char[][] board = new char[A][A];
        ArrayList<ArrayList<String>> answer = new ArrayList<>();
        for(int i =0;i< A;i++){
            for(int j=0;j<A;j++){
                board[i][j] = '.';
            }
        }
        backtrack(board,0,A,answer);

        return answer;
    }

    public static void backtrack(char[][] board, int row, int n, ArrayList<ArrayList<String>> solution){
        if(row == n){
            return;
        }
       for(int col=0;col<n;col++){
           if(isSafe(board,row,col,n)){
               board[row][col] = 'Q';// place the queen
               backtrack(board,row+1,n,solution);
               board[row][col] = '.'; // backtrack queen
           }
       }
    }

    public static boolean isSafe(char[][] board, int row,int col,int n){
        for(int i=0;i< row;i++){

        }
        return true;
    }
}
