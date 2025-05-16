package com.dsa.practice.everyday;

import java.util.ArrayList;
import java.util.Arrays;

/*
1. maximum consecutive 1's
2. Swap 0 with 1
3. Majority Element

TO DO - Make all elements in row and column zero if A[i][j] is 0 (interview class of intermediate)
 */
public class Day39 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(0,1,1,1,0,1,1,0,1,1,0));
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1,3,4,5,2,2,2,2,2,2));
        int answer = maxConsecutive(list,true);
        System.out.println(answer);
        int MajorityElement = maxMajority(list1);
        System.out.println(MajorityElement);
    }

    public static int maxConsecutive(ArrayList<Integer> A, boolean firstQuestion){

        int length = A.size();
        int totalCountOfOne = 0;
        for(int i=0;i<length;i++){
            if(A.get(i) == 1){
                totalCountOfOne++;
            }
        }
        if(totalCountOfOne ==0){
            return 1;
        }
        if(totalCountOfOne == length){
            return length;
        }
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<length;i++){
            int left =0;
            int right=0;
            if(A.get(i) == 0){
                for(int j=i-1;j>=0;j--){
                    if(A.get(j) == 1){
                        left++;
                    }else {
                        break;
                    }
                }

                for(int k=i+1;k<length;k++){
                    if(A.get(k) == 1){
                        right++;
                    }else {
                        break;
                    }
                }
                if(firstQuestion){
                    int currentcount = left+right+1;
                    ans = Integer.max(ans,currentcount);
                }else{//second question because only this condition is different.
                    if(totalCountOfOne == left + right){// this to check if we swap the border values probably.
                        ans = Integer.max(ans,(left + right));
                    }else{
                        ans = Integer.max(ans,(left+right+1));
                    }
                }

            }
        }
        return ans;
    }

    public static int maxMajority(ArrayList<Integer> A){
        int majority = A.get(0);
        int freq=1;
        int len = A.size();
        for(int i=1;i<len;i++){
            if(freq ==0){
                majority = A.get(i);
                freq=1;
            }else {
                if(A.get(i) == majority){
                    freq++;
                }else{
                    freq--;
                }
            }
        }
        // now checking the freq of the majority element
        freq=0;
        for(int i=0;i<len;i++){
            if(majority == A.get(i)){
                freq++;
            }
        }
        if(freq > len/2){
            return majority;
        }
        else{
            return -1;
        }
    }
}
