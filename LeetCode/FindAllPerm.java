package org.example.Study.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class FindAllPerm {

    public  static  void main(String[] args){
        int[] nums = {1,2,3};
        find(nums);
    }
    public static  List<List<Integer>> find(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        backtack(ans,new ArrayList<>(), nums);
        return  ans;
    }

    private static void backtack(List<List<Integer>> ans, ArrayList<Integer> temp, int[] nums) {
        if(temp.size() == nums.length){
            ans.add(new ArrayList<>(temp));
        }
        for(int n : nums) {
            if (temp.contains(n)) continue;

            temp.add(n);

            backtack(ans,temp,nums);

            temp.removeLast();
        }
    }
}
