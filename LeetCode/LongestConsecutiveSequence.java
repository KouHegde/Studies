package org.example.Study.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int n : nums) {
            set.add(n);
        }

        int max = 0;

        for (int n : set) {
            if (!set.contains(n - 1)) { //This is just to avoid o(n^2)
                int curr = n;
                int length = 1;

                while (set.contains(curr + 1)) {
                    curr++;
                    length++;
                }

                max = Math.max(max, length);
            }
        }

        return max;
    }
}
