package org.example.Study.LeetCode;

public class SearchInRotatedArray {

    public static void main(String[] args){
        int nums[] = {1,2 ,3, 4 ,5 ,7};;
        int target  = 2;
        int ans = bSearch(nums,target);
        System.out.println(ans);
    }

    private static int search(int[] nums,int target){
        int start  = 0;
        int end  = nums.length-1;

        while(start <= end){
            int mid  = start + (end - start)  / 2;

            if(nums[mid] == target){
                return  mid;
            }
            if(nums[start] < nums[mid]){
                if(nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                }else {
                   start = mid +1;
                }
            } else {
                if(nums[mid] < target && target <= nums[end]){
                    start = mid +1;
                } else {
                    end = mid -1;
                }

            }

        }
        return 0;
    }


    public static int bSearch(int[] nums,int target){
        int start  = 0;
        int end  = nums.length-1;

        while(start <= end){
            int mid  = start + (end - start) / 2;
            if (nums[mid] == target){
                return  mid;
            }
             if(target < nums[mid]){
                 end = mid-1;
             } else {
                 start = mid +1;
             }
        }
        return  0;

    }




}
