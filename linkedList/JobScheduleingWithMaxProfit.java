package org.example.Study.linkedList;

import java.util.Arrays;

public class JobScheduleingWithMaxProfit {class Solution {

    class Job {
        int start, end, profit;

        Job(int s, int e, int p) {
            this.start = s;
            this.end = e;
            this.profit = p;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        // Step 1: Create jobs list
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        // Step 2: Sort by start time
        Arrays.sort(jobs, (a, b) -> a.start - b.start);

        // Step 3: Extract start times for binary search
        int[] starts = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = jobs[i].start;
        }

        // Step 4: DP memo
        Integer[] dp = new Integer[n];

        return dfs(0, jobs, starts, dp);
    }

    private int dfs(int i, Job[] jobs, int[] starts, Integer[] dp) {
        if (i >= jobs.length) return 0;

        if (dp[i] != null) return dp[i];

        // Option 1: Skip current job
        int skip = dfs(i + 1, jobs, starts, dp);

        // Option 2: Take current job
        int nextIndex = findNextIndex(starts, jobs[i].end);
        int take = jobs[i].profit + dfs(nextIndex, jobs, starts, dp);

        return dp[i] = Math.max(skip, take);
    }

    // Binary search: first index where start >= target
    private int findNextIndex(int[] starts, int target) {
        int low = 0, high = starts.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (starts[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}


}
