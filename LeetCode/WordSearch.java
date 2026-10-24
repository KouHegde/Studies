package org.example.Study.LeetCode;

public class WordSearch {

    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(word.charAt(0) == board[i][j]){
                    if( dfs(i,j,word,0,board)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean dfs(int i , int j , String word,int index, char[][] board){
        if(index == word.length()) return true;

        if(i<0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(index) != board[i][j]) return false;

        char temp = board[i][j];
        board[i][j] = '#';

        boolean result = dfs(i-1,j, word,index+1,board)
                || dfs(i,j-1, word,index+1,board)
                || dfs(i+1,j, word,index+1,board)
                || dfs(i,j+1, word,index+1,board) ;
        board[i][j] = temp;

        return result;
    }

}
