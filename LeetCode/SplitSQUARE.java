package org.example.Study.LeetCode;

public class SplitSQUARE {

    class Solution {
        public double separateSquares(int[][] squares) {
            double low  = Double.MIN_VALUE;
            double high = Double.MAX_VALUE;
            double area = 0;

            for(int[] square : squares){
                int y = square[1];
                int top = y + square[2];

                low = Math.min(low,y);
                high = Math.max(high, top);
                area += (double)  square[2] * square[2];
            }

            double target = area/2;

            while(high - low > 1e-5){
                double mid = (low + high)/2;

                if(areaAbove(mid, squares) > target){
                    low = mid;
                } else {
                    high = mid;
                }
            }
            return low;
        }

        public double areaAbove(double mid, int[][] squares){
            double area = 0;

            for(int[] square : squares){
                int y = square[1];
                int top = square[2] + y;

                if(top < mid) continue;

                if( y >= mid){
                    area += (double) square[2]*square[2];
                } else{
                    double aboveY = top - mid;
                    area +=  aboveY*square[2];
                }
            }
            return area;

        }

    }
}
