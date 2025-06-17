package com.dsa.practice.everyday;

import java.util.*;

/*
1. Flipkart's Challenge in Effective Inventory Management
2. Distribute Candy.
 */
public class Day9 {
    public static void main(String[] args) {
        ArrayList<Integer> A1= new ArrayList<>(Arrays.asList(1,7,6,2,8,4,4,6,8,2));// expiry time
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(8,11,7,7,10,8,7,5,4,9));// profit
        int answer = maxProfit(A1,B);
        System.out.println(answer);
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 5, 2, 1));
        int candyAnswer = candy(A);
        System.out.println(candyAnswer);
    }
    public static int maxProfit(ArrayList<Integer> A, ArrayList<Integer> B){
        class Pair {
            int expiry, profit;
            Pair(int e, int p) {
                expiry = e;
                profit = p;
            }
        }

        List<Pair> items = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            items.add(new Pair(A.get(i), B.get(i)));
        }
        int mod = 1000000007;
        items.sort(Comparator.comparing(a-> a.expiry));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int time =0;
        int totalProfit=0;
        for(Pair item : items){
            if(time < item.expiry){
                pq.offer(item.profit);
                totalProfit = ((totalProfit + item.profit) % mod);
                time++;
            }
            else{
                if(item.profit > pq.peek()){
                    int lessProfit = pq.poll();
                    totalProfit = ((totalProfit - lessProfit) % mod + mod) % mod;
                    pq.offer(item.profit);
                    totalProfit = ((totalProfit + item.profit)% mod);

                }
            }
        }
        return totalProfit;
    }

    public static int candy(ArrayList<Integer> A){
       ArrayList<Integer> answerList = new ArrayList<>();
       int answer=0;
       for(int i : A){
           answerList.add(1);
       }
        for(int i =0;i<A.size()-1;i++){
            if(A.get(i) > A.get(i+1)){
                answerList.set(i,answerList.get(i) + 1);
            }
        }
        for(int j=A.size()-1;j>0;j--){
            if(A.get(j) > A.get(j-1)){
                answerList.set(j,answerList.get(j) + 1);
            }
        }
        System.out.println(answerList);
        for(int ans : answerList){
            answer += ans;
        }
       return answer;
    }
}
