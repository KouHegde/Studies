package org.example.Study.LeetCode;

public class TileNxM {

    public static int fill(int n , int m ){
        int[] dp = new int[n + 1];


        for (int i = 0; i <= n; i++) {
            if (i < m) {
                dp[i] = 1;                      // empty board = 1 way
            } else if (i == m) {
                dp[i] = 2;                      // only all-1×1 possible
            } else {
                dp[i] = dp[i-1] + dp[i-m];     // use 1×1 or 1×m tile
            }
        }


        return dp[n];
    }


}
