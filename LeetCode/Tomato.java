package org.example.Study.LeetCode;

import java.util.*;

public class Tomato {

    public static void main(String[] args) {
        String input = "this is a tomato it is not a vegetable it is really a fruit";
        String[] words = input.toLowerCase().split("\\s+");

        Map<String, List<String>> model = buildBigramModel(words);

        String startWord = "a";
        int steps = 4;

        String result = predict(model, startWord, steps);
        System.out.println(result);
    }

    /**
     * Builds a bigram frequency model.
     * Each word maps to a list of next words, sorted by descending frequency.
     * Wraps around: last word maps back to first word.
     */
    private static Map<String, List<String>> buildBigramModel(String[] words) {
        Map<String, Map<String, Integer>> freqMap = new HashMap<>();
        
        int n = words.length;
        for (int i = 0; i < n; i++) {
            String current = words[i];
            String next = words[(i + 1) % n]; 

            freqMap
                    .computeIfAbsent(current, k -> new HashMap<>())
                    .merge(next, 1, Integer::sum);
        }


        Map<String, List<String>> model = new HashMap<>();
        freqMap.forEach((word, counts) -> {
            List<String> sorted = new ArrayList<>(counts.keySet());
            sorted.sort((a, b) -> counts.get(b) - counts.get(a));
            model.put(word, sorted);
        });

        return model;
    }

    /**
     * Predicts the next `steps` words starting from startWord.
     */
    private static String predict(Map<String, List<String>> model, String startWord, int steps) {
        StringJoiner joiner = new StringJoiner(" ");
        String current = startWord;

        for (int i = 0; i < steps; i++) {
            List<String> next = model.getOrDefault(current, Collections.emptyList());
            if (next.isEmpty()) break;
            current = next.get(0);
            joiner.add(current);
        }

        return joiner.toString();
    }
}



