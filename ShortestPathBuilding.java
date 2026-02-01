package org.example.Study.Graphs;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestPathBuilding {

    public static int minimum(int[][] graph){
        int m = graph.length;
        int n = graph[0].length;

        int numberOfbuildings = 0;

        int[][] visitors = new int[m][n];
        int[][] distance = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0; j < n ; j++){
                if(graph[i][j] == 1) {
                    numberOfbuildings++;
                    bfs(i, j, graph, m, n, visitors, distance);
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for(int i = 0 ; i < m ; i++){
            for(int j = 0; j < n ; j++){
                if(graph[i][j] == 0 ){
                    if(visitors[i][j] != numberOfbuildings) return -1;
                    else{
                     min =   Math.min(min, distance[i][j]);
                    }

                }

            }
        }
        return min;
    }

    private static void bfs(int i, int j, int[][] graph, int m , int  n, int[][] visitor, int[][] distance) {

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] check = new boolean[m][n];

        check[i][j]  = true;

        q.add(new int[] {i,j,0});
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        while(!q.isEmpty()){
            int[] tuple  = q.poll();
            int row = tuple[0];
            int col = tuple[1];
            int currentDistance = tuple[2];

            for(int k = 0; k < 4 ; k++){
                int nr = dr[k] + row;
                int nc = dc[k] + col;

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                if(graph[nr][nc] == 1) continue;


                if(graph[nr][nc] != 2 && !check[nr][nc]){
                    distance[nr][nc] += currentDistance +1;
                    check[nr][nc] = true;
                    visitor[nr][nc]++;
                    q.add(new int[] { nr,nc,1+currentDistance});
                }
            }
        }
    }


}





