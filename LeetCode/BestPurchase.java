package org.example.Study.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class BestPurchase {

    public static List<Integer> findMaximumValue(List<Integer> prices, List<Integer> pos, List<Long> amount) {

        int n = prices.size();
        int q = pos.size();
        List<Integer> results = new ArrayList<>();


        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + prices.get(i);
        }


        for (int i = 0; i < q; i++) {

            int startIdx = pos.get(i) - 1;
            long budget = amount.get(i);


            if (startIdx >= n || prices.get(startIdx) > budget) {
                results.add(0);
                continue;
            }

            // Binary search for maximum items
            int low = startIdx;
            int high = n - 1;
            int maxItems = 0;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                long currentCost = prefixSum[mid + 1] - prefixSum[startIdx];

                if (currentCost <= budget) {
                    maxItems = mid - startIdx + 1;
                    low = mid + 1;
                } else {
                    high = mid - 1; // Reduce items
                }
            }

            results.add(maxItems);
        }

        return results;
    }
}
