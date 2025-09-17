package org.example.Study.LeetCode;

import java.util.*;

public class GroupAnagram {


    public static void main(String[] args){
        List<String> inputString = List.of("CAR", "RAC", "CAGE", "GEAC");
        List<List<String>> ans  = groupAnagrams(inputString);


    }

    private static List<List<String>> groupAnagrams(List<String> inputString) {
        if(Objects.isNull(inputString)){
            return new ArrayList<>();
        }
        Map<String,List<String>> freqMap = new HashMap<>();
        for(String s : inputString){
          String freqString = getFrequencyString(s);

          if(freqMap.containsKey(freqString)){
              freqMap.get(freqString).add(s);
          } else{
              List<String> list = new ArrayList<>();
              list.add(s);
              freqMap.put(freqString,list);
          }
        }
        return new ArrayList<>(freqMap.values());
    }

    private static String getFrequencyString(String s) {
        if(Objects.isNull(s)) return "";

        int[] freq = new int[26];

        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        char c = 'a';
        for(int i : freq){
            sb.append(c);
            sb.append(i);
            c++;
        }
        return sb.toString();
    }




    public static List<List<String>> groupAna(String[] strings){
        if(strings == null) return  new ArrayList<>();

        Map<String,List<String>> map = new HashMap<>();
        for(String s : strings){
            String freqString  = getFreq(s);

            if(map.containsKey(freqString)){
                map.get(freqString).add(s);
            } else{
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(freqString,list);
            }

        }
        return new ArrayList<>(map.values());

    }

    private static String getFreq(String s) {
        if(s==null) return "";

        int[] freq = new int[26];

        for(Character c: s.toCharArray()){
            freq['a'-c]++;
        }

        StringBuilder sb = new StringBuilder();
        char c = 'a';
        for(int n: freq){
            sb.append(c);
            sb.append(n);
            c++;
        }
        return sb.toString();
    }
}
