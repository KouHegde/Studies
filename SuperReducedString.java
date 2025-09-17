package org.example.Study.LeetCode;

import java.util.List;

public class SuperReducedString {

    public static void main(String[] args){
        String  s  = "abba";
        superReducedString(s);


    }

    public static String superReducedString(String s) {
        StringBuilder sb  = new StringBuilder();

        for(Character c : s.toCharArray()){
            int len   = sb.length();
            if(len > 0 && sb.charAt(len -1 )== c){
                sb.deleteCharAt(len-1);
            } else sb.append(c);
        }
        return sb.length() > 0 ? sb.toString() : "Empty String";
    }

}
