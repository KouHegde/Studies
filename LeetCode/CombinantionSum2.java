package org.example.Study.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinantionSum2 {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        int n = candidates.length;

        calculate(candidates,target,0,ans, new ArrayList<>());
        return ans;
    }

    public void calculate(int[] nums, int target, int i ,List<List<Integer>> ans,List<Integer> temp ){

        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(target < 0 || i == nums.length ) return;

        temp.add(nums[i]);

        calculate(nums,target-nums[i],i,ans,temp);

        temp.remove(temp.size()-1);

        calculate(nums,target,i+1,ans,temp);

    }

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        calculate(list,new ArrayList<>(),0,target, nums);
        return list;
    }

    void calculate(List<List<Integer>>  ans, List<Integer> temp, int start, int target, int[] nums){
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue;

            if(nums[i] > target) break;

            temp.add(nums[i]);
            calculate(ans,temp,i+1,target-nums[i],nums);
            temp.remove(temp.size() -1);
        }

    }


    public List<List<Integer>> combinationSumPractice(int[] nums, int target){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(ans, temp,nums, target, 0);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> temp, int[] nums, int target, int i) {

        if(i == nums.length || target < 0) return;

        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[i]);

        dfs(ans,temp,nums,target-nums[i],i);

        temp.remove(temp.size()-1);

        dfs(ans, temp,nums, target,i+1);


    }


    public static List<List<Integer>> combinationSum2OPrac(int[] nums, int target){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs2(ans, temp,nums, target, 0);
        return ans;

    }

    private static void dfs2(List<List<Integer>> ans, List<Integer> temp, int[] nums, int target, int i) {
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int idx = i; i < nums.length; i++){

            if(nums[idx] > target) break;

            if(idx > i && nums[i] == nums[i-1]) continue;

            temp.add(nums[idx]);

            dfs2(ans, temp,nums, target- nums[idx], i+1);

            temp.removeLast();
        }
    }
}
