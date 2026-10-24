package org.example.Study.LeetCode;

public class FriendsPairing {

    public static  int pairFriends(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + (i-1)*(dp[i-2]);
        }
        return dp[n];
    }
}
