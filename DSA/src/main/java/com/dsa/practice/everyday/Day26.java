package com.dsa.practice.everyday;

public class Day26 {
    public static void main(String[] args) {
        String A = "scaler";
        String ans = solve(A);
        System.out.println(ans);
    }

    public static String solve(String A){
        char[] chars = A.toCharArray();
        int len = A.length();
        for(int i=0;i<len;i++){
            char s = (char) (chars[i] + 'a');
            char e = (char) (chars[len-1-i] + 'a');
            swap(chars,s,e);
        }
        return String.valueOf(chars);
    }

    public static void swap(char[] chars,char s, char e){
        char temp = chars[s];
        chars[s] =  chars[e];
        chars[e] = temp;
    }
}
