package org.example.Study.LeetCode;

public class ContainerWithMaxWater {

    public static int maxWater(int[] heights){
        if(heights.length == 0 ) return 0;

        int left = 0;
        int right = heights.length-1;
        int ans = 0;

        while(left < right){
            int tempAns = (right-left) * Math.min(heights[left],heights[right]);
            ans =Math.max(tempAns,ans);
             if(heights[left] > heights[right]){
                 right--;
             } else {
                 left++;
             }
        }
        return ans;
    }

}
