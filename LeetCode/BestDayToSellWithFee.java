package org.example.Study.LeetCode;

public class BestDayToSellWithFee {


    public static int bestDayToSellWithFee(int[] nums , int fees) {
        int obs = -nums[0];
        int oss = 0;


        for (int i = 0; i < nums.length; i++) {
            int nbs = 0;
            int nss = 0;

            if (oss - nums[i] < obs) {
                nbs = oss - nums[i];
            } else {
                nbs = obs;
            }
            if (nums[i] - obs - fees > oss) {
                nss = nums[i] - obs - fees;
            } else {
                nss = oss;
            }
            obs = nbs;
            oss = nss;
        }
        return oss;
    }

}
