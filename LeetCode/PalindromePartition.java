package org.example.Study.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> ans = new ArrayList<>();
            List<String> temp = new ArrayList<>();
            dfs(s, 0, ans, temp);
            return ans;
        }

        private void dfs(String s, int index, List<List<String>> ans, List<String> temp) {
            if (index == s.length()) ans.add(new ArrayList<>(temp));

            for (int i = index; i < s.length(); i++) {

                String part = s.substring(index, i + 1);

                if (!isPalindrome(part)) {

                    temp.add(part);

                    dfs(s, i + 1, ans, temp);

                    temp.removeLast();
                }
            }

        }

        private boolean isPalindrome(String part) {
            int left = 0;
            int right = part.length() - 1;

            while (left < right) {
                if (part.charAt(left) != part.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
}
