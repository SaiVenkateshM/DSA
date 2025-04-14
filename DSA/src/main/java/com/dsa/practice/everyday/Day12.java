package com.dsa.practice.everyday;

import java.util.ArrayList;
import java.util.Arrays;

/*
1. Find the peak element.
 */
public class Day12 {
    public static void main(String[] args) {
        ArrayList<Integer> givenlist = new ArrayList<>(Arrays.asList(5, 17, 100, 11));
        int answer = findPeak(givenlist);

        System.out.println(answer);
    }

    public static int findPeak(ArrayList<Integer> given){
       int answer = 0;
       int left = 0;
       int size = given.size();
       int right = size -1;
       if(size == 1)
           return given.get(0);
       if(given.get(0) >= given.get(1)){
           return given.get(0);
       }
       if(given.get(size-1) >= given.get(size-2)){
           return given.get(size-1);
       }

       while(left<=right){
           int mid = (left + right)/2;
           if(given.get(mid) > given.get(mid -1) && given.get(mid) > given.get(mid+1)){
               return given.get(mid);
           }else if(given.get(mid) < given.get(mid -1)){
               right = mid -1;
           }else{
               left = mid +1;
           }
       }


        return answer;
    }
}
