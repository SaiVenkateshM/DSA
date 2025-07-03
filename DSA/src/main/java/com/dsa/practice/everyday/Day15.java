package com.dsa.practice.everyday;

import java.util.*;

/*
1. Rotten Oranges.
2. Commutable Islands
 */
public class Day15 {
    public static void main(String[] args) {
        int[][] C = {{2, 1, 1},{1, 1, 0},{0, 1, 1}};
        int answer = timeToRot(C);
        System.out.println(answer);
        int[][] B = {{1, 2, 1},{2, 3, 4},{1, 4, 3},{4, 3, 2},{1, 3, 10}};
        int A =4;
        int answer1 = commutableIsland(A,B);
        System.out.println(answer1);
    }

    public static int timeToRot(int[][]A){

        int[] dx = {-1,0,1,0};
        int[] dy = {0,-1,0,1};
        Queue<Pair> queue = new LinkedList<>();
        int n = A.length;
        int m = A[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(A[i][j] == 2){
                    queue.offer(new Pair(i,j));
                }
            }
        }
        int time =0;
        while(queue.size() != 0){
            int sz = queue.size();
            for(int k=0;k<sz;k++){
                Pair rp = queue.poll();
                for(int l=0;l<4;l++){
                    int newi = rp.i + dx[l];
                    int newj = rp.j + dy[l];
                    if(newi >=0 && newi <n && newj >=0 && newj<m && A[newi][newj] == 1){
                        A[newi][newj] = 2;
                        queue.add(new Pair(newi,newj));
                    }
                }
            }
            time++;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(A[i][j] == 1){
                    return -1;
                }
            }
        }
        return time-1;
    }

    public static int commutableIsland(int A, int[][] B){
        List<List<Pair>> graph = new ArrayList<>();

        for(int i=0;i<=A;i++){
            graph.add(new ArrayList<>());
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[A + 1];

    }
}
class Pair{
    int i;
    int j;

    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
