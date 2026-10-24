package org.example.Study.LLD;


import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

 class GameManager {

    private final ConcurrentHashMap<String, Game> games =
            new ConcurrentHashMap<>();

    public String createGame(int n, Player p1, Player p2) {

        String gameId = UUID.randomUUID().toString();

        Game game = new Game(gameId, n, p1, p2);

        games.put(gameId, game);

        return gameId;
    }

    public int makeMove(String gameId,
                        int row,
                        int col,
                        int playerId) {

        Game game = games.get(gameId);

        if (game == null)
            throw new IllegalArgumentException("Game not found");

        return game.makeMove(row, col, playerId);
    }

    public void removeGame(String gameId) {
        games.remove(gameId);
    }

    public Game getGame(String gameId) {
        return games.get(gameId);
    }
}

class Game {

    private final String gameId;

    private final TicTacToeNXN ticTacToe;

    // Lock only this game
    private final ReentrantLock lock = new ReentrantLock();

    public Game(String gameId, int n, Player p1, Player p2) {
        this.gameId = gameId;
        this.ticTacToe = new TicTacToeNXN(n, p1, p2);
    }

    public int makeMove(int row, int col, int playerId) {

        lock.lock();

        try {
            return ticTacToe.makeAMove(row, col, playerId);
        } finally {
            lock.unlock();
        }
    }

    public void printBoard() {
        ticTacToe.printBoard();
    }

    public String getGameId() {
        return gameId;
    }
}

public class TicTacToeNXN {

    int n;
    int[] rows;
    int[] cols;
    int diagonal;
    int antiDiagonal;
    int[][] board;

    Player player1;
    Player player2;

    // Tracks whose turn it is
    int currentPlayerId;

    public TicTacToeNXN(int n, Player player1, Player player2) {

        this.n = n;

        this.rows = new int[n];
        this.cols = new int[n];
        this.board = new int[n][n];

        this.player1 = player1;
        this.player2 = player2;

        this.currentPlayerId = player1.id;
    }

    public int makeAMove(int row, int col, int playerId) {


        if (playerId != currentPlayerId) {
            throw new IllegalStateException("It's not Player " + playerId + "'s turn.");
        }


        if (row < 0 || row >= n || col < 0 || col >= n) {
            throw new IllegalArgumentException("Invalid row or column.");
        }


        if (board[row][col] != 0) {
            throw new IllegalStateException("Cell already occupied.");
        }


        board[row][col] = playerId;

        int value = (playerId == player1.id) ? 1 : -1;


        rows[row] += value;
        cols[col] += value;

        if (row == col) {
            diagonal += value;
        }

        if (row + col == n - 1) {
            antiDiagonal += value;
        }


        if (isWinner(row, col)) {
            return playerId;
        }


        currentPlayerId =
                (currentPlayerId == player1.id)
                        ? player2.id
                        : player1.id;

        return 0;
    }

    private boolean isWinner(int row, int col) {

        return Math.abs(rows[row]) == n
                || Math.abs(cols[col]) == n
                || Math.abs(diagonal) == n
                || Math.abs(antiDiagonal) == n;
    }

    public void printBoard() {

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                char ch = '.';

                if (board[i][j] == player1.id) {
                    ch = player1.symbol;
                } else if (board[i][j] == player2.id) {
                    ch = player2.symbol;
                }

                System.out.print(ch + " ");
            }

            System.out.println();
        }
    }

    boolean isWinnerFound(char[][] board, int n){

        return checkIsRowWinner(board,n) || checkIsColWinner(board,n) || checkIsDiagonalWinner(board,n) || checkAntiDiagonalWinner(board,n);

    }

    private static boolean checkIsRowWinner(char[][] board, int n) {

        for (int i = 0; i < n; i++) {

            char firstChar = board[i][0];

            if (firstChar == '.')
                continue;

            int count = 1;

            for (int j = 1; j < n; j++) {
                if (board[i][j] == firstChar)
                    count++;
                else
                    break;
            }

            if (count == n)
                return true;
        }

        return false;
    }

    private static boolean checkIsColWinner(char[][] board, int n) {

        for (int j = 0; j < n; j++) {

            char firstChar = board[0][j];

            if (firstChar == '.')
                continue;

            int count = 1;

            for (int i = 1; i < n; i++) {
                if (board[i][j] == firstChar)
                    count++;
                else
                    break;
            }

            if (count == n)
                return true;
        }

        return false;
    }

    private static boolean checkIsDiagonalWinner(char[][] board, int n) {

        char first = board[0][0];

        if (first == '.')
            return false;

        int count = 1;

        for (int i = 1; i < n; i++) {
            if (board[i][i] == first)
                count++;
            else
                break;
        }

        return count == n;
    }

    private static boolean checkAntiDiagonalWinner(char[][] board, int n) {

        char first = board[0][n - 1];

        if (first == '.')
            return false;

        int count = 1;

        for (int i = 1; i < n; i++) {
            if (board[i][n - 1 - i] == first)
                count++;
            else
                break;
        }

        return count == n;
    }

}

class Player{
    public Player(int id, char symbol, String namme) {
        this.id = id;
        this.symbol = symbol;
        this.namme = namme;
    }

    int id;
    char symbol;
    String namme;
}



