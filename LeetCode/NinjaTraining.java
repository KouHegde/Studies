package org.example.Study.LeetCode;

public class NinjaTraining {

    public static int ninja(int[][] sheet){
        int n = sheet.length;
        int[][] dp = new int[sheet.length][4];
        return recursion(n-1, sheet, 3);
    }

    private static int recursion(int day, int[][] sheet, int lastTask) {
        if(day == 0){
            int maxi = 0;

            for(int task = 0; task < 3; task++){
                if(task != lastTask){
                    maxi = Math.max(maxi,sheet[0][task]);
                }
            }
            return maxi;
        }

        int max = 0;

        for(int task = 0; task < 3; task++){
            if(task != lastTask){
                int tempMax = sheet[day][task] + recursion(day-1,sheet,task);
                max = Math.max(tempMax,max);
            }
        }

        return max;
    }

    private static int dp1(int day, int[][] sheet, int lastTask, int[][] dp) {

        if(dp[day][lastTask] != -1) return dp[day][lastTask];

        if(day == 0) {
            int maxi = 0;

            for (int task = 0; task < 3; task++) {
                if (task != lastTask) {
                    maxi = Math.max(maxi, sheet[0][task]);
                }
            }
            return maxi;
        }

        int max = 0;

        for(int task = 0; task < 3; task++){

            if(task != lastTask){
                int tempMax = sheet[day][task] + dp1(day-1,sheet,task,dp);
                max = Math.max(tempMax,max);
            }
        }

        return dp[day][lastTask] = max;
    }


    private static int dp2(int[][] sheet){
        int[][] dp = new int[sheet.length][4];
        for(int last = 0; last < 4; last++){
            int max = 0;
            for(int t = 0; t<3; t++) {
                if(last != t) {
                    dp[0][last] = Math.max(max,dp[0][t]);
                }
            }

        }
        for(int day =1 ; day < sheet.length; day++){
            for (int last = 0 ; last < 4; last++){
                dp[day][last] =0;
                for(int task = 0; task < 3; task++){
                    if(last != task){
                        dp[day][last] =Math.max(dp[day][last], sheet[day][task] + dp[day-1][task]);
                    }
                }
            }

        }
        return dp[sheet.length-1][3];
    }

    private static int dp3(int[][] sheet) {
        int n = sheet.length;
        int[][] dp = new int[n][4];

        // Base case: day 0
        dp[0][0] = Math.max(sheet[0][1], sheet[0][2]);
        dp[0][1] = Math.max(sheet[0][0], sheet[0][2]);
        dp[0][2] = Math.max(sheet[0][0], sheet[0][1]);
        dp[0][3] = Math.max(sheet[0][0], Math.max(sheet[0][1], sheet[0][2]));

        for (int day = 1; day < n; day++) {
            dp[day][0] = Math.max(sheet[day][1] + dp[day-1][1], sheet[day][2] + dp[day-1][2]);

            dp[day][1] = Math.max(sheet[day][0] + dp[day-1][0], sheet[day][2] + dp[day-1][2]);

            dp[day][2] = Math.max(sheet[day][0] + dp[day-1][0], sheet[day][1] + dp[day-1][1]);

            dp[day][3] = Math.max(dp[day][0], Math.max(dp[day][1], dp[day][2]));
        }

        return dp[n-1][3];
    }


    public static int dpMethod(int[][] sheet){
        int days = sheet.length;
        int[][] dp = new int[days][4];

        dp[0][0] = Math.max(dp[0][1],dp[0][2]);
        dp[0][1] = Math.max(dp[0][0],dp[0][2]);
        dp[0][2] = Math.max(dp[0][1],dp[0][0]);
        dp[0][3] = Math.max(dp[0][1], Math.max(dp[0][2],dp[0][0]));

        for(int day = 1 ; days<days; day++){
            for(int last = 0 ; last < 4;last++){
                dp[day][last] = 0;

                for(int task = 0; task < 3; task++){
                    if(task  != last){
                        dp[day][last] = Math.max(dp[day][last],sheet[day][last] + dp[day-1][task]);
                    }
                }
            }
        }
        return dp[days][3];
    }

    public static int dpSol(int[][] sheet){
        int m = sheet.length;
        int n = 3;

        int[][] dp = new int[m][n];

        dp[0][0] = sheet[0][0];
        dp[0][1] = sheet[0][1];
        dp[0][2] = sheet[0][2];

        for(int i = 1; i < m ; i++){
            dp[i][0] = sheet[i][0] + Math.max(dp[i-1][1],dp[i-1][2]);
            dp[i][1]= sheet[i][1] + Math.max(dp[i-1][0],dp[i-1][2]);
            dp[i][2]= sheet[i][2] + Math.max(dp[i-1][1],dp[i-1][0]);

        }
        return Math.max(dp[m-1][0],Math.max(dp[m-1][1],dp[m-1][2]));
    }

    public static int dpSol2(int[][] sheet){
        int m = sheet.length;
        int n = 3;


        int r = sheet[0][0];
        int g  = sheet[0][1];
        int b = sheet[0][2];

        for(int i = 1; i < m ; i++){
            int nr= sheet[i][0] + Math.max(g,b);
            int ng = sheet[i][1] + Math.max(r,b);
            int nb = sheet[i][2] + Math.max(r,g);
            r=nr;
            g=ng;
            b=nb;

        }
        return Math.max(r,Math.max(g,b));
    }





}
