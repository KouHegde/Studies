package org.example.Study.LeetCode;

import java.util.*;

public class MergeIntervals {

    public static void main(String[] args){
        int[][] intervals  = {{1,4},{4,5}};
        int[][] ans  = mergeI(intervals);
        System.out.println(ans);
    }

    private static int[][] mergeI(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparing(i->i[0]));
        int[] current = intervals[0];
        List<int[]> ans   = new ArrayList<>();
        for(int[] ints : intervals){
            int firstEnd  = current[1];
            int secondStart = ints[0];
            int nextEnd = ints[1];
            if(firstEnd>= secondStart){
                current[1] = Math.max(firstEnd,nextEnd);
            } else {
                ans.add(current);
                current = ints;

            }

        }
        ans.add(current);
        return ans.toArray(new int[ans.size()][]);
    }






  private static int[][] mergeBro(int[][] intervals){
        Arrays.sort(intervals,Comparator.comparing(i->i[0]));
        List<int[]> ans  = new ArrayList<>();
        int[] curr = intervals[0];
        for(int[] ints : intervals){
            int firstEnd = curr[1];
            int secondStart = curr[0];
            int secondEnd  = curr[1];

            if(firstEnd >= secondStart){
                curr[1] = Math.max(firstEnd,secondEnd);
            } else{
                ans.add(curr);
                curr = ints;
            }
        }
        ans.add(curr);
    return ans.toArray(new int[ans.size()][]);
  }



  public static int[][] merged(int[][] intervals){
        Arrays.sort(intervals,Comparator.comparing(i->i[0]));
        int[] curr = intervals[0];
        List<int[]> ans = new ArrayList<>();
        for(int[] ints : intervals){
            int firstEnd = curr[1];
            int secondStart = curr[0];
            int secondEnd = curr[1];

            if(firstEnd>=secondStart){
                curr[1] = Math.max(firstEnd,secondEnd);
            } else{
                ans.add(curr);
                curr = ints;
            }
       }
        ans.add(curr);
        return ans.toArray(new int[ans.size()][]);
  }

}
