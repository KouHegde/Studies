package org.example.Study.LeetCode;

public class NextPermutation {

    private static int[] nextPerm(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int n = nums.length;


        int i = n - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {

            int j = n - 1;

            while (nums[i] >= nums[j] ) {
                j--;
            }

            swap(nums, i, j);
        }

        reverse(nums, i + 1, n - 1);

        return nums;
    }

    private static void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start, int end) {

        while (start < end) {

            swap(nums, start, end);

            start++;
            end--;
        }
    }


}
