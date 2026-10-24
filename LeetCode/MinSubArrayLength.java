package org.example.Study.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class MinSubArrayLength {
    public static int maxSubArrayLenSW(int target, int[] nums) {

        int left = 0;

        int sum = 0;

        int max = 0;

        for(int right = 0; right < nums.length; right++) {

            sum += nums[right];

            while(sum > target) {

                sum -= nums[left];

                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }



    public static int maxSubArrayLen(int target, int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int prefix = 0;

        int max = 0;

        for(int i = 0; i < nums.length; i++) {

            prefix += nums[i];

            if(map.containsKey(prefix - target)) {

                max = Math.max(max, i - map.get(prefix - target));
            }

            map.putIfAbsent(prefix, i);
        }

        return max;
    }
}
