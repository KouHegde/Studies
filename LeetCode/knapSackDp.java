package org.example.Study.LeetCode;

public class knapSackDp {
    private static final int NEG_INF= (int)-1e9;
    public static int main(int[] wt, int[]val, int maxWeight){
        int n = wt.length;
        return recursion(wt,val,n-1,maxWeight);
    }

    private static int recursion(int[] wt, int[] val, int i, int maxWeight) {
        if(i == 0){
            if(wt[0] <= maxWeight) return val[0];
            else  return 0;
        }

        int notPick = recursion(wt,val,i-1,maxWeight);
        int pick= NEG_INF;
        if(wt[i] <= maxWeight) pick = val[i] + recursion(wt,val,i-1,maxWeight-wt[i]);

        return Math.max(pick,notPick);
    }


    private static int dpSol(int[] wt, int[] val, int maxWeight){
        int n = wt.length;
        int[][]dp = new int[n][maxWeight+1];
        for(int weight  = 0; weight <= maxWeight; weight++){
            if(wt[0] <= weight){
                dp[0][weight] = val[0];
            }
        }

        for(int i = 1; i < n; i++){
            for(int weight= 0; weight<= maxWeight;weight++){
                int notPick = dp[i-1][weight];
                int pick = NEG_INF;
                if(wt[i] <= weight) pick= val[i]+dp[i-1][weight-wt[i]];
                dp[i][weight] = Math.max(pick,notPick);
            }
        }
        return dp[n-1][maxWeight];
    }
}
