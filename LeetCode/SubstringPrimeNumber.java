package org.example.Study.LeetCode;

public class SubstringPrimeNumber {

    public static int numberOfPrimeSubstringPartition(String numbers){
        Integer[] dp = new Integer[numbers.length()];
        return  dfs(dp,numbers,0);
    }

    private static int dfs(Integer[] dp, String numbers, int index) {
        if(index == numbers.length()) return 1;

        if(dp[index] != null) return dp[index];

        int ways = 0;

        for(int i = index; i <  numbers.length(); i++){
            if(isPrime(Integer.parseInt(numbers.substring(index,i+1)))){
               ways = 1 + dfs(dp,numbers,i+1);
            }
        }
        return dp[index] = ways;
    }

    private static boolean isPrime(int part) {
        if(part < 2) return false;

        if(part == 2) return true;

        for( int i = 3; i * i <= part; i++){
            if(part % i == 0)  return false;
        }
        return true;
    }



}
