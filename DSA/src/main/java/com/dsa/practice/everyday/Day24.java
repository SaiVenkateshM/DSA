package com.dsa.practice.everyday;

import java.util.ArrayList;
import java.util.Arrays;

public class Day24 {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,2,3));
        ArrayList<ArrayList<Integer>> answer = backTrackingPermutations(A);
        System.out.println(answer);
        int B = 3;
        ArrayList<String> ans = generateParenthesis(B);
        System.out.println(ans);
        ArrayList<Integer> C = new ArrayList<>(Arrays.asList(1,2,3));
        ArrayList<ArrayList<Integer>> subsetsAns = subsets(C);
        System.out.println(subsetsAns);
    }

    public static ArrayList<ArrayList<Integer>> backTrackingPermutations(ArrayList<Integer> A){
        int n = A.size();
        boolean[] used = new boolean[n];
        Arrays.fill(used,false);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ans = permutations(A,new ArrayList<>(),ans,used);
        return ans;
    }
    
    public static ArrayList<ArrayList<Integer>> permutations(ArrayList<Integer> A, ArrayList<Integer> temp,ArrayList<ArrayList<Integer>> ans,boolean used[]){
        if(temp.size() == A.size()){
            ans.add(new ArrayList<>(temp));
            return ans;
        }
        for(int i=0;i<A.size();i++) {
            if (used[i] == false) {
                temp.add(A.get(i));
                used[i] = true;
                permutations(A, temp, ans, used);
                temp.remove(A.get(i));
                used[i] = false;
            }
        }

        return ans;
    }

    public static ArrayList<String> generateParenthesis(int A){
        ArrayList<String> answer = new ArrayList<>();
        answer = backtracking(answer,"",0,0,A);

        return answer;
    }

    public static ArrayList<String> backtracking(ArrayList<String> answer,String current,int open, int close, int max){
        if(current.length() == 2 * max){
           answer.add(current);
           return answer;
        }
        if(open < max){
            backtracking(answer,current + "(",open+1,close,max);
        }

        if(close < open){
            backtracking(answer,current + ")",open,close+1,max);
        }

        return  answer;
    }

    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ans = backtrack(A,0,new ArrayList<>(),ans);
        return ans;
    }

    public static ArrayList<ArrayList<Integer>> backtrack(ArrayList<Integer> A,int idx,ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> ans){
        if(idx == A.size()){
            ans.add(new ArrayList<>(cur));
            return ans;
        }
        cur.add(A.get(idx));
        backtrack(A,idx+1,cur,ans);
        cur.remove(cur.size() -1);
        backtrack(A,idx +1,cur,ans);
        return ans;
    }
}
