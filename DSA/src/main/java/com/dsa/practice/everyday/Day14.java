package com.dsa.practice.everyday;

import java.util.*;

/*
1. detect a cyclic graph.
2. Path in Directed Graph
 */
public class Day14 {
    public static void main(String[] args) {
        int[][] B = {{1,2},{4,1},{2,4},{3,4},{5,2},{1,3}};
        int A = 5;
        int answer = detectCyclic(A,B);
        int secondAnswer = pathDirectedGraph(A,B);
        System.out.println("1st->" + answer);
        System.out.println("2nd->" + secondAnswer);
    }

    public static int detectCyclic(int A,int[][]B){

        // add the edges to Adjacency list.
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : B) {
            graph.get(edge[0]).add(edge[1]);
        }
        //System.out.println(graph);
        int[] state = new int[A + 1]; // 0 = unvisited, 1 = visiting, 2 = visited

        for (int i = 1; i <= A; i++) {
            if (state[i] == 0) {
                if (dfs(i, graph, state)) {
                    return 1; // cycle found
                }
            }
        }
        return 0; // no cycle
    }

    private static boolean dfs(int node, ArrayList<ArrayList<Integer>> graph, int[] state) {
        state[node] = 1; // mark as visiting

        for (int neighbor : graph.get(node)) {
            if (state[neighbor] == 1) {
                return true; // cycle detected
            }
            if (state[neighbor] == 0) {
                if (dfs(neighbor, graph, state)) {
                    return true;
                }
            }
        }
        state[node] = 2; // mark as visited
        return false;
    }

    public static int pathDirectedGraph(int A, int[][] B){
        // Adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=A;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : B){
            graph.get(edge[0]).add(edge[1]);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        boolean[] visited = new boolean[A +1];

        while(!queue.isEmpty()){
            int current = queue.poll();
            if(visited[current]){
                continue;
            }
            visited[current] = true;
            if(current == A){
                return 1; // found the path
            }else{
                for(int neighbor : graph.get(current)){
                    if(!visited[neighbor]){
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return 0;
    }
}
