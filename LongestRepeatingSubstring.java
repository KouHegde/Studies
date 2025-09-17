package org.example.Study.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class LongestRepeatingSubstring {


    public static void main(String[] args){
        String s = "abcabcab";
        int ans  = longestRepeatingSub(s);

    }

    private static int longestRepeatingSub(String s) {
        Set<Character> setd  = new HashSet<>();

        int left  = 0;
        int maxLength  = 0;

        for(int right = 0; right< s.length()-1; right++){
            while (setd.contains(s.charAt(right))){
                setd.remove(s.charAt(left));
                left++;
            }
            setd.add(s.charAt(right));
            maxLength = Math.max(maxLength, right-left+1);


        }
        return maxLength;
    }

    public int longestRepeatingSubstring(String s){
        int left  = 0;
        int maxLength = 0;
        Set<Character> setd = new HashSet<>();

        for(int right  = 0; right < s.length() -1; right++){
            while(setd.contains(s.charAt(right))){
                setd.remove(s.charAt(left));
                left++;
            }
            setd.add(s.charAt(right));
            maxLength = Math.max(maxLength, left+right-1);
        }
        return maxLength;
    }



    public static int lon(String s){

        int left  =0;
        int max = 0;

        Set<Character> set = new HashSet<>();

        for(int right = 0; right < s.length()-1; right++){
           while(set.contains(s.charAt(right))){
               set.remove(s.charAt(left));
               left++;
           }
           set.add(s.charAt(right));
           max = Math.max(max,right+left-1);
        }
        return max;
    }
}
