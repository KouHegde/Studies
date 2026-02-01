package org.example.Study.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Anagram {

    public static void main(String[] args){
        String s1= "CARJP";
        String s2 = "RAC";
        isvalidAnagram(s1, s2);
    }

    private static boolean isvalidAnagram(String s1, String s2) {

        if(s1.length() != s2.length()){
            return false;
        }

        Map<Character,Integer> countMap = new HashMap<>();

        for(Character ch : s1.toCharArray()){
            countMap.put(ch,countMap.getOrDefault(ch,0)+1);
        }

        for(Character ch : s2.toCharArray()){
            int charCount = countMap.getOrDefault(ch,0);
            if(charCount > 0){
                int updatedCharCount = charCount -1;
                countMap.put(ch,updatedCharCount);
                if(updatedCharCount ==0) {
                    countMap.remove(ch);
                }
            }

        }
        return countMap.isEmpty();
    }


    public boolean anagram(String s1,String s2){
        if(s1.length() != s2.length()) return false;
        HashMap<Character,Integer> map = new HashMap<>();
        for(Character ch: s1.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        for (Character ch : s2.toCharArray()){
            if(!map.containsKey(ch)){
                return false;
            }
            int chSize = map.get(ch);

            if(chSize>1){
                map.put(ch,chSize-1);
            } else {
                map.remove(ch);
            }

        }
        return map.isEmpty();

    }

    public boolean isAnAnagram(String s1, String s2){
        if(s1.length() != s2.length()) return false;
        Map<Character,Integer> f1 =new HashMap<>();


        for(int  i = 0 ; i<s1.length() ;i++){
            f1.put(s1.charAt(i), f1.getOrDefault(s1.charAt(i),0)+1);
            f1.put(s2.charAt(i), f1.getOrDefault(s2.charAt(i),0)-1);
        }

        for(int val : f1.values()){
            if(val != 0){
                return false;
            }
        }
        return true;
    }



}
