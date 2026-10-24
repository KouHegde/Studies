package org.example.Study.LeetCode;

public class KnapSackUnbounded {

    private static final int NEG_INF = (int) -1e9;

    public static int knapSackUnbounded(int[] wt, int[] val, int maxWeight){
        int n = wt.length;
        return recursion(wt,val,maxWeight,n-1);
    }

    private static int recursion(int[] wt, int[] val, int maxWeight,int i) {
        if(i == 0){
            if(wt[0] < maxWeight) return (maxWeight/wt[0])*val[0];
        }

        int notPick = recursion(wt,val,maxWeight,i-1);
        int pick = NEG_INF;
        if(wt[i]<= maxWeight) pick = val[i]+recursion(wt,val,maxWeight,i);
        return Math.max(pick,notPick);
    }

    private static int dpSol(int[] wt, int[] val, int maxWeight){
        int n = wt.length;
        int[][] dp = new int[n][maxWeight+1];

        for(int w  = 0 ; w <= maxWeight; w++){
            if(wt[0] <= w) dp[0][w] = w/wt[0] * val[0];
        }

        for(int i = 1; i < n ; i++){
            for(int w  = 0 ; w <= maxWeight; w++){
                int notPick = dp[i-1][w];
                int pick =NEG_INF;
                if(wt[i] <= w) pick = val[i] + dp[i][w - wt[i]];
                dp[i][w] = Math.max(pick,notPick);
            }
        }
        return dp[n-1][maxWeight];

    }
}
