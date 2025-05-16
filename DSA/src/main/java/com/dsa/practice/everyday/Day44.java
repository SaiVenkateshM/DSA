package com.dsa.practice.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*
Hashing
1.
 */
public class Day44 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(4, -1, 1));

        int answer = subArraySumZero(list);
        System.out.println(answer);
    }
    public static int subArraySumZero(ArrayList<Integer> A){
        int len = A.size();
        int sum = 0;
        HashSet<Integer> set = new HashSet<>();
        set.add(sum);
        for(int i=0;i<len;i++){
            sum += A.get(i);
            if(set.contains(sum)){
                return 1;
            }else{
                set.add(sum);
            }
        }
        return 0;
    }
}
