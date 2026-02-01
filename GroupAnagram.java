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
          freqMap.getOrDefault(freqString,new ArrayList<>()).add(s);
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
            if (i > 0) {
                sb.append(c);
                sb.append(i);
            }
            c++;
        }
        return sb.toString();
    }

    public List<List<String>> groupAnagram(List<String> words){
        if(words == null) return null;

        Map<String,List<String>> map = new HashMap<>();

        for(String word : words){
            String freq = getFreqMap(word);

            if(map.containsKey(freq)){
                map.get(freq).add(word);
            } else{
                map.put(freq,new ArrayList<>());
                map.get(freq).add(word);
            }
        }

        return new ArrayList<>(map.values());

    }

    private String getFreqMap(String word) {
        if(word == null) return "";

        int[] alpha = new int[26];

        for(Character ch : word.toCharArray()){
            alpha[ch - 'a']++;
        }

        char ch = 'a';
        StringBuilder sb = new StringBuilder();

        for(int i : alpha){
            if(alpha[i] != 0){
                sb.append(ch);
                sb.append(alpha[i]);
            }
            ch++;
        }
        return sb.toString();


    }


}
