package org.example.Study.LeetCode;

public class LongestBeautifulString {
    public int longestBeautifulSubstring(String word) {

        int max = 0;
        int count = 1;      // current length
        int unique = 1;     // unique vowel groups

        for (int i = 1; i < word.length(); i++) {

            char prev = word.charAt(i - 1);
            char curr = word.charAt(i);

            // increasing order
            if (curr >= prev) {

                count++;

                // new vowel encountered
                if (curr != prev) {
                    unique++;
                }

            } else {
                // reset
                count = 1;
                unique = 1;
            }

            // all 5 vowels present
            if (unique == 5) {
                max = Math.max(max, count);
            }
        }

        return max;
    }

}
