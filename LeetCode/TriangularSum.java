package org.example.Study.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class TriangularSum {

    public int triangularSum(int[] nums) {
        int n = nums.length;
        int[] coeff = new int[n];
        coeff[0] = 1;

        // Build binomial coefficients C(n-1, i)
        for (int i = 1; i < n; i++) {
            coeff[i] = (int)((long)coeff[i - 1] * (n - 1 - i + 1) / i);
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (sum + coeff[i] * nums[i]) % 10;
        }
        return sum;
    }

    public static int triangularSum2(int[] nums){
        List<Integer> start = new ArrayList<>(); // 1+2 , 3+4
        for(int n : nums){
            start.add(n);
        }

        while(start.size()>1){
            List<Integer> next = new ArrayList<>();
            for(int i = 0 ; i < start.size(); i+=2){
                if(i+1 < start.size()){
                    int first = start.get(i);
                    int second = start.get(i+1);
                    next.add((first+second) % 10);
                } else{
                    next.add(start.get(i));
                }
                start = next;
            }
        }
        return start.get(0);

    }


    public static int triangularSum3(int[] nums){

        List<Integer> start = new ArrayList<>(); //1+2,2+3,3+4
        for(int n : nums){
            start.add(n);
        }

        while(start.size() > 1){

            List<Integer> next = new ArrayList<>();

            for(int i = 0; i < start.size() - 1; i++){
                int first = start.get(i);
                int second = start.get(i+1);
                next.add((first + second) % 10);
            }

            start = next;
        }

        return start.get(0);
    }
}
