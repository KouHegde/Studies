package org.example.Study.LeetCode;

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int max = 0;

        for(int[] trip : trips){
            max =  Math.max(max,trip[2]);
        }
        int[] timeline = new int[max+1];
        for(int[] trip : trips){
            int start = trip[1];
            int end = trip[2];
            int p = trip[0];

            timeline[start]+= p;
            timeline[end]-= p;
        }
        int t = 0;
        for(int n : timeline){
            t += n;
            if(t>capacity){
                return false;
            }
        }
        return true;
    }
}
