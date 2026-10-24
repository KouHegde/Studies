package org.example.Study.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();

        Stack<Integer> st = new Stack<>();

        for(int n : nums2){
            while(!st.isEmpty() && st.peek() < n){
                map.put(st.pop(), n);
            }
            st.push(n);
        }

        while(!st.isEmpty()){
            map.put(st.pop(), -1);
        }
        int[] ans = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }




}
