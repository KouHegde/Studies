package org.example.Study.LeetCode;

public class LongestCommonSubDp {
    public static int lcs(String s1, String s2){
        int n = s1.length();
        int m = s2.length();

        return recursion(s1,s2,n,m);
    }

    private static int recursion(String s1, String s2, int i, int j) {
        if(i  == 0 || j == 0) return 0;

        if(s1.charAt(i-1) == s2.charAt(j-1)) {
          return   1 + recursion(s1, s2, i - 1, j - 1);
        }
        return Math.max(recursion(s1,s2,i-1,j) ,recursion(s1,s2,i,j-1));
    }

    private static int dpSol(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];

        for(int i  = 1 ; i <=n ; i++) dp[0][i] = 0;
        for(int j = 1 ; j<= m ; j++) dp[j][0] = 0;

        for(int i = 1; i<= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                dp[i][j] = Math.max(dp[i-1][j] ,dp[i][j-1]);

            }
        }
        return dp[n][m];
    }
}
