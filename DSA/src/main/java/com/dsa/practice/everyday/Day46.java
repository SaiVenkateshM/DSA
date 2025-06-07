package com.dsa.practice.everyday;
/*
1. Boring Substring
2. Window String

 */

import java.util.Arrays;
import java.util.HashMap;


public class Day46 {
    public static void main(String[] args) {
        String A = "abcd";
        int answer = boringSubstring(A);
        System.out.println(answer);
        String A1= "ADOBECODEBANC";
        String B= "ABC";
        String answer1 = windowProblem(A1,B);
        System.out.println(answer1);

    }
    public static int boringSubstring(String A){
        int len = A.length();
        String even = "";
        String odd = "";
        for(int i=0;i<len;i++){
            if(A.charAt(i) % 2 == 0){
                even = even + A.charAt(i);

            }
            else{
                odd = odd + A.charAt(i);
            }
        }
        char[] unsortedEven = even.toCharArray();
        Arrays.sort(unsortedEven);
        char[] unsortedOdd = odd.toCharArray();
        Arrays.sort(unsortedOdd);

        if(check(odd + even)){
            return 1;
        }else if(check(even + odd)){
            return 1;
        }

        return 0;
    }

    public static boolean check(String isBoring){
        boolean ok = true;
        for (int i = 0; i + 1 < isBoring.length(); ++i)
            ok &= (Math.abs(isBoring.charAt(i) - isBoring.charAt(i + 1)) != 1);
        return ok;
    }

    public static String windowProblem(String A, String B){
        HashMap<Character,Integer> Bmap = new HashMap<>();
        HashMap<Character,Integer> Amap = new HashMap<>();

        char[] bCharacters = B.toCharArray();
        for(int i=0;i<bCharacters.length;i++){
            Bmap.put(bCharacters[i], Bmap.getOrDefault(bCharacters[i],0)+1);
        }
        int start =0;
        int end=0;
        int minLen = Integer.MAX_VALUE;
        String answer = "";
        char[] aCharacters = A.toCharArray();
        for( end=0;end<aCharacters.length;end++){
            Amap.put(aCharacters[end],Amap.getOrDefault(aCharacters[end],0) +1);
            if(checkWindow(Amap,Bmap)){
                //int currentWindow = A[0];
                while(start <= end){
                    answer += aCharacters[start];
                    start++;
                }
            }
            else{
                start++;
            }
        }
        return answer;
    }

    public static boolean checkWindow(HashMap<Character,Integer> aMap,HashMap<Character,Integer> bMap){
        for(char c : bMap.keySet()){
            if(!aMap.containsKey(c) || aMap.get(c) < bMap.get(c)){
                return false;
            }
        }
        return true;
    }
}
