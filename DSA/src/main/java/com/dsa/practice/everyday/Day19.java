package com.dsa.practice.everyday;

import java.util.*;

/*
1. Another BFS
2.
 */
public class Day19 {
    public static void main(String[] args) {
        int A =6;
        int[][] B = {{2,5,1},{1,3,1},{0,5,2},{0,2,2},{1,4,1},{0,1,1}};
        int C = 3;
        int D = 2;
        int answer = anotherBFS(A,B,C,D);
        System.out.println(answer);
    }

    public static int anotherBFS(int A,int[][]B,int C,int D){

        int count =0;
        for(int i=0;i<A;i++){
            if(B[i][2] == 2){
                count++;
            }
        }
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(A + count +1);
        for(int i=0;i<A + count +1;i++){
            graph.add(new ArrayList<>());
        }
        count =0;
        for(int i=0;i<A;i++){
            int x = B[i][0];
            int y = B[i][1];
            int weight = B[i][2];

            if(weight == 1){
                graph.get(x).add(y);
                graph.get(y).add(x);
            }else{
                count ++;
                graph.get(x).add(A + count);
                graph.get(y).add(A + count);
                graph.get(A + count).add(x);
                graph.get(A + count).add(y);
            }
        }

        boolean[] visited = new boolean[A + count + 1];
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(C,0));
        while(!queue.isEmpty()){
            Pair current = queue.poll();
            if(current.i == D){
                return current.j;
            }
            visited[current.i] = true;
            for(int neighbor : graph.get(current.i)){
                if(!visited[neighbor]){
                    queue.offer(new Pair(neighbor,current.j +1));
                }
            }
        }
        return -1;
    }
}
