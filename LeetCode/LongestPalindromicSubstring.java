package org.example.Study.LeetCode;

import java.util.Arrays;

public class LongestPalindromicSubstring {
    public boolean check(String s,int i,int j,int t[][]){
        if(i>j){
            return true;
        }
        if(t[i][j]!=-1){
            return t[i][j]==1;
        }

        if(s.charAt(i)==s.charAt(j)){
            if(check(s,i+1,j-1,t)){
                t[i][j]=1;
                return true;
            }
        }
        t[i][j]=0;
        return false;
    }
    public String longestPalindrome(String s) {   //Recursion+Memo

        String ans="";
        int t[][]=new int[s.length()][s.length()];
        for(int r[]:t){
            Arrays.fill(r,-1);
        }

        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                boolean is =check(s,i,j,t);
                if(is){
                    if(ans.length()<s.substring(i,j+1).length()){
                        ans=s.substring(i,j+1);
                    }
                }
            }
        }

        return ans;
    }



    public String longestPalindromeNoDp(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);       // odd length
            int len2 = expand(s, i, i + 1);   // even length

            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() &&
                s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // length
    }
}

