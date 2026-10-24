package org.example.Study.LeetCode;

public class MaxJump5XDp {
    class Solution {
        public int maxJumps(int[] arr, int d) {
            int n = arr.length;

            Integer[] dp = new Integer[n];

            int ans = 1;

            for(int i = 0 ; i < n ; i++){
                ans = Math.max(ans, dfs(dp,n, arr, d, i));
            }
            return ans;
        }

        public int dfs(Integer[] dp, int n, int[] arr, int d, int in){
            if(dp[in] != null) return dp[in];

            int best = 1;

            for(int left = in-1; left >= Math.max(0, in - d); left--){
                if(arr[in] <= arr[left]) break;
                best = Math.max(best, 1 + dfs(dp,n,arr,d,left));
            }

            for(int right = in+1 ; right <= Math.min(n-1, in+d); right++){
                if(arr[in] <= arr[right]) break;
                best =  Math.max(best, 1 + dfs(dp,n,arr,d,right));
            }
            return dp[in] = best;
        }
    }
}
