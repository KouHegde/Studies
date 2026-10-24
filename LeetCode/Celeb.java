package org.example.Study.LeetCode;

public class Celeb {

    public static boolean knows(int a, int b) {
        // mock implementation (replace in real problem)
        return matrix[a][b] == 1;
    }

    static int[][] matrix;


    public static int findCelebrity(int n) {

        int possibleCeleb = 0;

        for (int i = 1; i < n; i++) {

            if (knows(possibleCeleb, i)) {
                possibleCeleb = i;
            }
        }

        for (int i = 0; i < n; i++) {

            if (i == possibleCeleb) continue;

            if (knows(possibleCeleb, i) ||
                    !knows(i, possibleCeleb)) {
                return -1;
            }
        }

        return possibleCeleb;
    }
}
