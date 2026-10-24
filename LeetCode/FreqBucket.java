package org.example.Study.LeetCode;

import java.util.*;

public class FreqBucket {


    public static List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> freq = new HashMap<>();

        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> pq =
                new PriorityQueue<>(
                        (a, b) -> {

                            int freqCompare =
                                    freq.get(b) - freq.get(a);

                            if (freqCompare == 0) {
                                return a.compareTo(b);
                            }

                            return freqCompare;
                        }
                );

        pq.addAll(freq.keySet());

        List<String> ans = new ArrayList<>();

        for (int i = 0; i < k; i++) {

            ans.add(pq.poll());
        }

        return ans;
    }

    public static List<String> bucket(List<String> list, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String s : list) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        List<List<String>> bucket = new ArrayList<>();
        for(int i = 0; i <= list.size(); i++ ){
            bucket.add(new ArrayList<>());
        }

        for(String key : map.keySet()) {
            bucket.get(map.get(key)).add(key);
        }

        List<String> result = new ArrayList<>();

        for (int i = bucket.size() - 1; i >= 0; i--) {
            if (result.size() == k) break;
            if (bucket.get(i) != null) {
                for (String s : bucket.get(i)) {
                    result.add(s);
                    if (result.size() == k) return result;
                }
            }
        }

        return result;
    }
}
