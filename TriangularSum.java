package org.example.Study.LeetCode;

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
}
