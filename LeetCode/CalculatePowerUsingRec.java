package org.example.Study.LeetCode;

public class CalculatePowerUsingRec {


    private static double calculatePow(double x, int n) {
        long N = n; // convert to long

        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }

    private static double fastPow(double x, long n) {
        if (n == 0) return 1;

        double half = fastPow(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
