package org.example.Study.LeetCode;

public class MaxFrequestCharacterLengthWIthKReplacement {

    public static void main(String[] args){
        String s = "ABABA";
        int k = 2;
        maxFrequestCharacterLengthWIthKReplacement(s,  k);

    }

    public static int maxFrequestCharacterLengthWIthKReplacement(String s, int k) {
        int[] chars = new int[26];

        int left = 0;

        int maxFreq = 0;

        int maxLen = 0;

        for(int right = 0; right < s.length(); right++) {

            chars[s.charAt(right) - 'A']++;

            maxFreq = Math.max(maxFreq, chars[s.charAt(right) - 'A']);

            while((right - left + 1) - maxFreq > k) {

                chars[s.charAt(left) - 'A']--;

                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
