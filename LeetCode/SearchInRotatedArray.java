package org.example.Study.LeetCode;

public class SearchInRotatedArray {

    public static void main(String[] args){
        int nums[] = {1,2 ,3, 4 ,5 ,7};
        int target  = 2;
        int ans = bSearch(nums,target);
        System.out.println(ans);
    }

    private static int bSearch(int[] nums, int target) {

        if(nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {

            int mid = start + (end - start) / 2;

            if(nums[mid] == target) {
                return mid;
            }

            // left half sorted
            if(nums[start] <= nums[mid]) {

                if(nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            } else {

                // right half sorted
                if(nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }




}
