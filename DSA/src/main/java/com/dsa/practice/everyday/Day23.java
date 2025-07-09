package com.dsa.practice.everyday;

import java.util.ArrayList;
import java.util.Arrays;
/*
1. Russian Dolls
2. Check Bipartite Graph
 */

public class Day23 {
    public static void main(String[] args) {
        int[][] A = {{5,4},{6,4},{6,7},{2,3}};
        int answer = russianDolls(A);
        System.out.println(answer);

        int[][] B ={{0,1}};
        int C = 2;
        int answerBipartite = checkBipartite(C,B);
        System.out.println(answerBipartite);
    }
    public static int russianDolls(int[][] A){
        Arrays.sort(A, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            else return b[1] - a[1]; // descending width for same height
        });
        int n = A.length;
        int[] dp = new int[n];
        dp[0] =1;
        int ans = 1;
        for(int i=0;i<n;i++){
            int max = 0;
            for(int j=0;j<i;j++){
                if(A[j][1] < A[i][1] && A[j][0] < A[i][0]){
                    max = Math.max(max,dp[j]);
                }
            }
            dp[i] = 1 + max;
            ans = Math.max(ans,dp[i]);
        }

        return ans;
    }

    public static int checkBipartite(int A,int[][] B){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i=0;i<A;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : B){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int[] colour = new int[A];
        Arrays.fill(colour,-1);
        for(int i=0;i<A;i++){
            if(colour[i] == -1){
                if(!dfsCheck(graph,colour,i,0)){
                    return 0;
                }
            }
        }
        return 1;
    }

    public static boolean dfsCheck(ArrayList<ArrayList<Integer>> graph,int[] colour,int node,int currentColour){
        colour[node] = currentColour;
        for(int nbr : graph.get(node)){
            if(colour[nbr] == colour[node])
                return false;
            else if(colour[nbr] == -1){
                colour[nbr] = 1- colour[node];
                if(dfsCheck(graph,colour,nbr,colour[nbr]) == false){
                    return false;
                }
            }
        }
        return true;
    }
}
