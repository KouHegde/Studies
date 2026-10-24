package org.example.Study.LeetCode;

import java.util.Arrays;

public class MeetingRoom {
    class Solution {
        public int minMeetingRooms(int[][] intervals) {
            if (intervals == null || intervals.length == 0)
                return 0;

            int n = intervals.length;

            int[] start = new int[n];
            int[] end = new int[n];

            for (int i = 0; i < n; i++) {
                start[i] = intervals[i][0];
                end[i] = intervals[i][1];
            }

            Arrays.sort(start);
            Arrays.sort(end);

            int rooms = 0;
            int endPointer = 0;

            for (int i = 0; i < n; i++) {
                if (start[i] < end[endPointer]) {
                    rooms++;   // Need new room
                } else {
                    endPointer++;  // Reuse a room
                }
            }

            return rooms;
        }
    }



    public static int answer(int[][] rooms){
        int[] startTime = new int[rooms.length];
        int[] endTime = new int[rooms.length];


        for(int i = 0;  i < rooms.length; i++){
            int[] time = rooms[i];

            startTime[i] = time[0];
            endTime[i] = time[1];
        }

        Arrays.sort(startTime);
        Arrays.sort(endTime);

        int count = 0;
        int endPointer  = 0;
        int startPointer = 0;
        while(startPointer < startTime.length)
            if(startTime[startPointer] < endTime[endPointer]){
                count++;
                startPointer++;
            } else {
                startPointer++;
                endPointer++;
            }
        return count;
    }
}
