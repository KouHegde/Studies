package org.example.Study.LeetCode;

import java.util.Arrays;

public class BurstBallon {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[] arr = new int[n+2];
        arr[0] = 1;

        for(int i = 0 ; i < n; i++){
            arr[i+1] = nums[i];
        }
        arr[n+1] = 1;

        int[][]dp = new int[n+2][n+2];
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }

        return recusrion(arr,1,n, dp);
    }

    public static int recusrion(int[] arr, int i, int j, int[][] dp){
        if(i > j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int max = Integer.MIN_VALUE;

        for(int idx = i; idx <= j ; idx++ ){
            int cost = arr[idx] * arr[i-1] * arr[j+1] + recusrion(arr,i,idx-1,dp) + recusrion(arr,idx+1,j,dp);
            max = Math.max(cost,max);
        }
        return dp[i][j] = max;
    }
}
