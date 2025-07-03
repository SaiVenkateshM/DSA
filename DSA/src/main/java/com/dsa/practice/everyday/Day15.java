package com.dsa.practice.everyday;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
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
        System.out.println("2nd answer->" + answer1);
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
        for(int[] edge : B){
            graph.get(edge[0]).add(new Pair(edge[1],edge[2]));
            graph.get(edge[1]).add(new Pair(edge[0], edge[2])); // since its undirected graph
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[A + 1];

        int totalCost =0;
        pq.offer(new Pair(1,0)); // starting with the first and the cost for this is 0

        while(!pq.isEmpty()){
            Pair current = pq.poll();
            int node = current.i;
            int cost = current.j;

            if(visited[node])
                continue;
            totalCost += cost;
            visited[node] = true;

            for(Pair neighbour : graph.get(node)){
                if(!visited[neighbour.i]){
                    pq.offer(new Pair(neighbour.i, neighbour.j));
                }
            }
        }
        return totalCost;
    }
}
class Pair implements Comparable<Pair>{
    int i;
    int j;

    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public int compareTo(Pair other) {
        return this.j - other.j;
    }
}
