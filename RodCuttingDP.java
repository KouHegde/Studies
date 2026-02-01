package org.example.Study.LeetCode;

public class RodCuttingDP {

    public static int NEG_INF = (int) -1e9;

    public static int rodCutting(int[] prices,int N){
        int n = prices.length;
        return recursion(n-1,prices,N);
    }

    private static int recursion(int i, int[] prices, int N) {

        if(i == 0) return prices[0]*N;

        int notPick = recursion(i-1, prices,N);
        int pick = NEG_INF;
        if(i+1 <= N) pick = prices[i] + recursion(i, prices,N - (i+1));
        return Math.max(pick,notPick);
    }

    private static int dpSol(int[] prices, int N){
        int n  = prices.length;
        int[][] dp = new int[n][N+1];

        for(int j = 0 ; j<=N; j++){
            dp[0][j] = prices[0] * j;

        }

        for(int i = 1; i < n; i++){
            for(int j = 0; j <=N; j++){
                int notPick = dp[i-1][j];
                int pick = NEG_INF;
                if(i+1 <= j) pick = prices[i] + dp[i][j-(i+1)];
                dp[i][j] = Math.max(pick,notPick);
            }
        }
        return dp[n-1][N];
    }


}
