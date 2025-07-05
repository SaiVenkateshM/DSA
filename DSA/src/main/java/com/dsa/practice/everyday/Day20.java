package com.dsa.practice.everyday;

import java.util.ArrayList;
import java.util.PriorityQueue;
/*
1. Topological Sort.
 */


public class Day20 {
    public static void main(String[] args) {
        int A =6;
        int B[][] = {{6, 3},{6,1},{5,1},{5,2},{3,4},{4,2}};
        int[] answer = topologicalSort(A,B);
        for(int i=0;i<answer.length;i++){
            System.out.print(answer[i]+ " ");
        }
    }

    public static int[] topologicalSort(int A,int[][]B){
        int[] inbound = new int[A+1];
        int[] answer = new int[A];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<A+1;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : B){
            graph.get(edge[0]).add(edge[1]);
        }

        for(int i=1;i<=A;i++){
            for(int neighbor : graph.get(i)){
                inbound[neighbor]++;
            }
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();
        int answerCount =0;
        for(int i=1;i<=A;i++){
            if(inbound[i] ==0 ){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int remaining = q.poll();
            answer[answerCount] = remaining;
            answerCount++;
            for(int nbr : graph.get(remaining)){
                inbound[nbr] --;
                if(inbound[nbr] == 0){
                    q.offer(nbr);
                }
            }
        }
        if(answerCount < A){
            return new int[0];
        }

        return answer;
    }
}
