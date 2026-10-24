package org.example.Study.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubWithAtMostK {

    public static void main(String[] args){
        String s = "aaabbcd";
        longestSubWithlessThanK(s,2);
    }

    private static int longestSubWithlessThanK(String s, int k) {
        Map<Character,Integer> map = new HashMap<>();

        int left = 0;
        int max =0;

        for(int right = 0; right < s.length(); right++){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right),0)+1);

            if(map.size() > k){
                if(map.containsKey(s.charAt(left))){
                    int count = map.get(s.charAt(left))-1;
                    if(count <= 0){
                        map.remove(s.charAt(left));
                    } else{
                        map.put(s.charAt(left),count);
                    }
                }
                left++;
            }
            max = Math.max(max,right-left+1);
        }
        return max;
    }
}
