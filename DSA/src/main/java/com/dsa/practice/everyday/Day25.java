package com.dsa.practice.everyday;
/*
1. Letter Phone
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day25 {
    public static void main(String[] args) {
        String A = "23";
        ArrayList<String> ans = letterCombinations(A);
        System.out.println(ans);
        int B = 4;
        int C = 4;
        int answer = kSymbol(B,C);
        System.out.println(answer);
    }

    public static ArrayList<String> letterCombinations(String A){
        String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ArrayList<String> ans = new ArrayList<>();
        ans = combinations(A,0,new StringBuilder(),ans,mapping);
        Collections.sort(ans);
        return ans;
    }

    public static ArrayList<String> combinations(String A, int idx, StringBuilder current, ArrayList<String> ans,String[] mapping){
        if(idx == A.length()){
            ans.add(current.toString());
            return ans;
        }

        char currentNumber = A.charAt(idx);
        String letters = mapping[currentNumber - '0'];

        for(char ch : letters.toCharArray()){
            current.append(ch);
            combinations(A,idx +1,current,ans,mapping);
            current.deleteCharAt(current.length() - 1);
        }
        return ans;
    }

    public static int kSymbol(int A,int B){
            if (A == 1) return 0;

            int parent = kSymbol(A - 1, B / 2);
            boolean isOdd = B % 2 == 1;

            if (parent == 0) return isOdd ? 1 : 0;
            else return isOdd ? 0 : 1;

    }
}
