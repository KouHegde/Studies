package org.example.Study.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class Duplicate2 {

    public static boolean duplicateDiff(int[] nums, int K){

        Set<Integer> set = new HashSet<>();

        for(int i = 0 ; i < nums.length; i++){
            if(i > K) set.remove(i-K-1);
            if(!set.add(nums[i])){
                return true;
            }
        }
        return false;
    }
}
