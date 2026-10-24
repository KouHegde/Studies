package org.example.Study.LeetCode;

import java.util.Arrays;

public class MountainArray {

    public static void main(String[] args){
        int[] nums = {2,1,4,7,3,2,5};


    }


    public static int minChangesToMountain(int[] nums) {

        int n = nums.length;

        int[] lis = new int[n];

        int[] lds = new int[n];

        Arrays.fill(lis, 1);
        Arrays.fill(lds, 1);


        for(int i = 0; i < n; i++) {

            for(int j = i; j >= 0; j--) {

                if(nums[i] > nums[j]) {

                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }


        for(int i = n - 1; i >= 0; i--) {

            for(int j = i; j < n; j++) {

                if(nums[i] > nums[j]) {

                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }

        int ans = n;

        for(int i = 0; i < n; i++) {


            if(lis[i] > 1 && lds[i] > 1) {

                int mountainLength = lis[i] + lds[i] - 1;

                ans = Math.min(ans, n - mountainLength);
            }
        }

        return ans;
    }

    class Solution {
        public int longestMountain(int[] nums) {
            int n = nums.length;
            int[] lis = new int[n+1];
            int[] dis = new int[n+1];

            lis[0] = 0;
            dis[n-1] = 0;


            for(int i = 1; i < n ; i++){
                if(nums[i] > nums[i-1]){
                    lis[i] =lis[i-1] +1;

                }

            }
            for(int i = n-2; i >= 0; i--){

                if(nums[i] > nums[i+1]){
                    dis[i]= dis[i+1]+1;
                }

            }

            int ans = 0;

            for(int i = 0 ; i < n ; i++){
                if(lis[i]>0 && dis[i] > 0){
                    ans = Math.max(ans, lis[i] + dis[i] + 1);
                }

            }

            return ans;
        }
    }
}

