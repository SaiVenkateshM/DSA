package com.dsa.practice.everyday;

import java.util.*;

/*
1. Another BFS
2. Dijkstra Algorithim
 */
public class Day19 {
    public static void main(String[] args) {
        int A =6;
        int[][] B = {{2,5,1},{1,3,1},{0,5,2},{0,2,2},{1,4,1},{0,1,1}};
        int C = 3;
        int D = 2;
        int answer = anotherBFS(A,B,C,D);
        System.out.println(answer);

        int E=6;
        int[][] F = {{0, 4, 9},{3, 4, 6},{1, 2, 1},{2, 5, 1},{2, 4, 5},{0, 3, 7},{0, 1, 1},{4, 5, 7},{0, 5, 1}};
        int G= 4;
        int[] answer2 = dijkstra(E,F,G);
        for(int i=0;i< answer2.length;i++){
            System.out.print(answer2[i]);
        }
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

    public static int[] dijkstra(int A,int[][]B,int C){
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

        for(int i=0;i<A;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : B){
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            graph.get(u).add(new Pair(v,weight));
            graph.get(v).add(new Pair(u,weight));
        }

        int[] distance = new int[A];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[C] =0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(C,0));

        while(!pq.isEmpty()){
            Pair current = pq.poll();
            int currentNode = current.i;
            int currentDistance = current.j;

            if(distance[currentNode] != Integer.MAX_VALUE  && currentDistance >distance[currentNode]){
                continue;
            }

            for(Pair neighbor : graph.get(currentNode)){
                int nextNode = neighbor.i;
                int weight = neighbor.j;

                if (distance[currentNode] + weight < distance[nextNode]) {
                    distance[nextNode] = distance[currentNode] + weight;
                    pq.offer(new Pair(nextNode, distance[nextNode]));
                }
            }

        }

        for (int i = 0; i < A; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                distance[i] = -1;
            }
        }
        return distance;
    }
}
