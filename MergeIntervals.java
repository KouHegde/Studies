package org.example.Study.LeetCode;

import java.util.*;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {4, 5}};
        int[][] ans = mergeI(intervals);
        System.out.println(ans);
    }

    private static int[][] mergeI(int[][] intervals) {
        if (intervals == null) return null;
        if (intervals.length == 1) return intervals;

        Arrays.sort(intervals, Comparator.comparing(ints -> ints[0]));
        int[] first = intervals[0];
        List<int[]> ans = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {
            int[] second = intervals[i];

            if (first[1] >= second[0]) {
                first[1] = Math.max(first[1], second[1]);
            } else {
                ans.add(first);
                first = second;
            }

        }
        ans.add(first);
        return ans.toArray(new int[ans.size()][]);

    }


}