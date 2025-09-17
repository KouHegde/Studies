package org.example.Study.LeetCode;



public class TrappingRainWater {

    public static void main(String[] args){
        int[] height = {4,1,5,0,1};
        int ans  = trapSimple(height);
        System.out.println(ans);
    }



    public static int trapSimple(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = nums[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(nums[i], left[i - 1]);
        }

        right[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(nums[i], right[i + 1]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(left[i], right[i]) - nums[i];
        }
        return ans;
    }

    public static int trapHard1(int[] nums){
        int n = nums.length;
        int l = 0;
        int r = n-1;
        int lmax = nums[0];
        int rmax = nums[n-1];
        int ans  =0;

        while(l<=r){
            lmax = Math.max(lmax,nums[l]);
            rmax = Math.max(rmax,nums[r]);

            if(lmax<rmax){
                ans  = ans+lmax;
                l++;
            } else{
                ans = ans+rmax;
                r++;
            }
        }
        return ans;

    }


    private static int trap(int[] nums){
        if(nums== null|| nums.length == 0) return 0;
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = nums[0];
        for(int i =1; i< n; i++){
            left[i] = Math.max(left[i-1],nums[i]);
        }
        right[n-1] = nums[n-1];
        for(int j = n-2; j>=0; j--){
            right[j] = Math.max(right[j+1],nums[j]);
        }
        int ans = 0;
        for(int i =0; i < n; i++){
            ans+=Math.min(right[i],left[i])-nums[i];
        }
        return ans;


    }

}
