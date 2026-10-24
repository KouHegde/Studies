package org.example.Study.LeetCode;

public class PossibleTicTacToeOutcomes {

    private static final int[][][] winningLines = {

            {{0,0}, {0,1}, {0,2}},
            {{1,0}, {1,1}, {1,2}},
            {{2,0}, {2,1}, {2,2}},

            {{0,0}, {1,0}, {2,0}},
            {{0,1}, {1,1}, {2,1}},
            {{0,2}, {1,2}, {2,2}},

            {{0,0}, {1,1}, {2,2}},
            {{0,2}, {1,1}, {2,0}}
    };


    public static int calculate() {
        char[][] board = new char[3][3];

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = '_';

        return dfs(board, 'X');
    }

    private static int dfs(char[][] board, char current) {
        if (isWinner(board) || isOver(board)) {
            return 1;
        }

        int total = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '_') {
                    board[i][j] = current;
                    char next = current == 'X' ? 'O' : 'X';
                    total += dfs(board, next);
                    board[i][j] = '_';
                }
            }
        }
        return total;
    }

    public static boolean isWinner(char[][] board) {
        for (int[][] line : winningLines) {
            int r1 = line[0][0], c1 = line[0][1];
            int r2 = line[1][0], c2 = line[1][1];
            int r3 = line[2][0], c3 = line[2][1];

            if (board[r1][c1] != '_'
                    && board[r1][c1] == board[r2][c2]
                    && board[r2][c2] == board[r3][c3])
                return true;
        }
        return false;
    }

    public static boolean isOver(char[][] board) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == '_') return false;
        return true;
    }
}
