package org.example.Study.LeetCode;

import java.util.*;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {4, 5}};
        List<List<Integer>> ans = mergeInterval(intervals);
        System.out.println(ans);
    }



    public static List<List<Integer>> mergeInterval(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<List<Integer>> ans = new ArrayList<>();

        int[] first = intervals[0];

        for (int i = 1; i < intervals.length; i++) {

            int[] second = intervals[i];

            if (first[1] >= second[0]) {
                first[1] = Math.max(first[1], second[1]);
            } else {
                ans.add(Arrays.asList(first[0], first[1]));
                first = second;
            }
        }

        ans.add(Arrays.asList(first[0], first[1]));

        return ans;
    }


}