package org.example.Study.LeetCode;

public class LongestPalindromeCanBeCreatedFromAString {

    public int longestPalindrome(String s) {
        int[] chars = new int[58];
        for (char ch : s.toCharArray()) {
            chars[ch - 'A']++;
        }
        int total = s.length();
        int countOdd = 0;
        for (int n : chars) {
            if (n % 2 == 1) {
                countOdd++;
                total -= 1;
            }
        }
        if (countOdd == 0) {
            return total;
        }
        return total + 1;
    }
}
