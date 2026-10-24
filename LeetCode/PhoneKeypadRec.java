package org.example.Study.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneKeypadRec {
    class Solution {

        private static final Map<Character, String> MAP = new HashMap<>();

        static {
            MAP.put('2', "abc");
            MAP.put('3', "def");
            MAP.put('4', "ghi");
            MAP.put('5', "jkl");
            MAP.put('6', "mno");
            MAP.put('7', "pqrs");
            MAP.put('8', "tuv");
            MAP.put('9', "wxyz");
        }

        public List<String> letterCombinations(String digits) {

            List<String> result = new ArrayList<>();

            if (digits == null || digits.length() == 0) {
                return result;
            }

            backtrack(digits, 0, new StringBuilder(), result);

            return result;
        }

        private void backtrack(String digits, int index, StringBuilder current, List<String> result) {

            if (index == digits.length()) {

                result.add(current.toString());

                return;
            }

            String letters = MAP.get(digits.charAt(index));

            for (char c : letters.toCharArray()) {

                current.append(c);

                backtrack(digits, index + 1, current, result);

                current.deleteCharAt(current.length() - 1);
            }
        }
    }
}