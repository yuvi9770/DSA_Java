package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottonOranges {
    private static class pair{
        int row;
        int col;
        public pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int freshOrange = 0;
        int time = 0;

        Queue<pair> q = new LinkedList<>();

        for(int i =0; i < m; i++){
            for(int j =0; j < n; j++){
                if(grid[i][j] == 1)
                    freshOrange++;

                else if(grid[i][j] == 2){
                    q.add(new pair(i,j));
                }
            }
        }

        if (freshOrange == 0) return 0;

        int dir[][] = {{-1,0},{1,0},{0,1},{0,-1}};
        while (!q.isEmpty()) {
            int size = q.size();

            boolean isRotton = false;

            for (int i = 0; i < size; i++) {
                pair curr = q.remove();
                int r = curr.row;
                int c = curr.col;

                for (int j = 0; j < 4; j++) {
                    int nr = r + dir[j][0];
                    int nc = c + dir[j][1];

                    if (nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == 1) {
                        q.add(new pair(nr, nc));
                        grid[nr][nc] = 2;
                        freshOrange--;
                        isRotton = true;
                    }
                }
            }
            if(isRotton) time++;
        }

        return freshOrange == 0 ? time : -1;
    }


    public static void main(String[] args) {
        int arr[][] = {{2,1,1},{1,1,0},{0,1,1}};

        System.out.println(orangesRotting(arr));
    }
}