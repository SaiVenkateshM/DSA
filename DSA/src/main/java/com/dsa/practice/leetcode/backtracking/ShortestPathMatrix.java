package com.dsa.practice.leetcode.backtracking;

public class ShortestPathMatrix {
    public static void main(String[] args) {
        int[][] A = {{1, 1, 0, 0},{0, 1, 1, 0},{0, 0, 1, 1},{0, 0, 0, 1}};
        int B =0;
        int C =0;
        int D=3;
        int E=3;
        int answer = FindShortestPath(A,B,C,D,E);
        System.out.println(answer);
    }
    static int minSteps = Integer.MAX_VALUE;
    public static int FindShortestPath(int[][] A, int B, int C, int D, int E){
        int N = A.length;
        int M = A[0].length;

        if(A[B][C] ==0 || A[D][E] == 0) return -1;

        boolean[][] visited = new boolean[N][M];
        shortestPath(A,B,C,D,E,visited,0);

        return (minSteps == Integer.MAX_VALUE) ? 1 : minSteps;
    }
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void shortestPath(int[][] A,int x,int y,int destX, int destY, boolean[][] visited, int steps){
        if(x == destX && y == destY){
            minSteps = Math.min(minSteps,steps);
            return;
        }

        visited[x][y] = true;

        for(int dir=0;dir<4;dir++){
            int newX = x + dx[dir];
            int newY = y + dy[dir];

            if(isValid(newX,newY,A) && !visited[newX][newY] && A[newX][newY] == 1){
                shortestPath(A,newX,newY,destX,destY,visited,steps +1);
            }
        }
        visited[x][y] = false;
    }

    public static boolean isValid(int r, int c , int[][] A){
        return r >=0 && c>=0 && r <A.length && c < A[0].length;
    }
}
