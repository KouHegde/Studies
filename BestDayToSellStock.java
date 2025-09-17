package org.example.Study.LeetCode;

public class BestDayToSellStock {

    public static void main(String[] args){
        int[] prices  = {7,1,5,3,6,4};
        int profit  = maxProfit(prices);
        System.out.println(profit);
    }


    public static int maxProfit(int[] prices){
        int buyPrice  = prices[0];
        int profit  = 0;

        for(int i  = 1; i < prices.length-1; i++){
            if(prices[i] < buyPrice){
                buyPrice = prices[i];
            } else{
                int cp = prices[i] - buyPrice;
                profit = Math.max(profit,cp);
            }

        }
        return profit;
    }

    public static int bestDay(int[] prices){
        int bp = prices[0];
        int profit  = 0;

        for(int i = 0; i < prices.length-1; i++){
            if(prices[i] < bp){
                bp = prices[i];
            } else{
                int cp = bp - prices[i];
                profit = Math.max(cp, profit);
            }
        }
        return profit;
    }

    public static int bestDayTo(int[] nums){
        int bp = nums[0];
        int profit  = 0;

        for(int i  = 1; i< nums.length; i++){
            if(nums[i] < bp){
                bp = nums[i];
            } else{
                int cp  = bp - nums[i];
                profit = Math.max(profit,cp);
            }
        }
        return profit;
    }




    public int bestDayToSell(int[] nums){
        int bp = nums[0];
        int p = 0;

        for(int i = 1 ; i< nums.length; i++){
            if(nums[i] < bp){
                bp = nums[i];
            }
            int cp = bp - nums[i];
            p = Math.max(cp,p);
        }
        return p;
    }
}
