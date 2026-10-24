package org.example.Study.LeetCode;

public class BestDayToSellWithCooldown {

    public int maxProfit(int[] prices) {

        int obs = -prices[0];
        int oss = 0;
        int ocs = 0;

        for(int i = 0; i < prices.length ; i++){
            int nbs = Math.max(obs, ocs-prices[i]);
            int nss = Math.max(oss, prices[i] + obs);
            int ncs = Math.max(ocs,oss);

            obs = nbs;
            oss= nss;
            ocs = ncs;
        }
        return oss;

    }
}
