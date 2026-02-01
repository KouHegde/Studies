package org.example.Study.LeetCode;

public class palindrome {

    public static int LongestPalindrome(String s){
        String s1 = s;
        String s2 = new StringBuilder(s).reverse().toString();
        return lcs(s1, s2);
    }

    public static int minimumOperationsToMakeAPalindrome(String s1){
        String s2 = new StringBuilder(s1).reverse().toString();
        return s1.length() - lcs(s1,s2);
    }

    public static int minimumInsertionAndDeletionToConvertS1ToS2(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        return (n+m)- (2*(lcs(s1,s2)));
    }
    private static int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];

        for(int i = 0; i <= n ; i++)dp[i][0] = 0;
        for(int j = 0; j <= m ; j++)dp[0][j] = 0;

        for(int i = 1; i <=n; i++){
            for(int j =1; j<= m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

}
