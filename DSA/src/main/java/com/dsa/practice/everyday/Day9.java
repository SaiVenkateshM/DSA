package com.dsa.practice.everyday;

import java.util.*;

/*
1. Flipkart's Challenge in Effective Inventory Management
 */
public class Day9 {
    public static void main(String[] args) {
        ArrayList<Integer> A= new ArrayList<>(Arrays.asList(1,7,6,2,8,4,4,6,8,2));// expiry time
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(8,11,7,7,10,8,7,5,4,9));// profit
        int answer = maxProfit(A,B);
        System.out.println(answer);
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
}
