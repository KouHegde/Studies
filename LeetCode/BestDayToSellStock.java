package org.example.Study.LeetCode;

public class BestDayToSellStock {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int profit = maxProfit(prices);
        System.out.println(profit);
    }


    public static int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length - 1; i++) {
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            } else {
                int cp = prices[i] - buyPrice;
                profit = Math.max(profit, cp);
            }

        }
        return profit;
    }

    public static int bestDay(int[] prices) {
        int bp = prices[0];
        int profit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < bp) {
                bp = prices[i];
            } else {
                int cp = prices[i] -bp;
                profit = Math.max(cp, profit);
            }
        }
        return profit;
    }

}




