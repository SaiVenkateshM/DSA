package com.dsa.practice.leetcode.twoPointer;

public class reverseString {
    public static void main(String[] args) {
        String word = "abcdefd";
        char ch = 'd';
        String answr = reversePrefix(word,ch);
        System.out.println(answr);
    }

    public static String reversePrefix(String word, char ch){
        char[] chrs = word.toCharArray();
        int n = chrs.length;
        int start =0;
        int end =0;
        for(int i=0;i<n;i++){
            if(chrs[i] == ch){
                end = i;
                break;
            }
        }
        if(end == 0) return word;

        while(start < end){
            char temp = chrs[start];
            chrs[start] = chrs[end];
            chrs[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(chrs);

    }
}
