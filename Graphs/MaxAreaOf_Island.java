package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOf_Island {
    private static class pair{
        int row;
        int col;

        public pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static int bfs(int[][] grid, int i, int j, int m, int n){
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(i, j));
        grid[i][j] = 0;
        int area = 1;

        int dir[][] = {{-1,0},{0,-1},{1,0},{0,1}};
        while (!q.isEmpty()) {
            pair curr = q.remove();
            int r = curr.row;
            int c = curr.col;

            for (int k = 0; k < 4; k++) {
                int nr = r + dir[k][0];
                int nc = c + dir[k][1];

                if (nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == 1) {
                    q.add(new pair(nr, nc));
                    grid[nr][nc] = 0;
                    area++;
                }
            }
        }

        return area;
    }

    public static int dfs(int[][] grid, int i, int j, int m, int n){
        if (i < 0 || i >= m || j < 0 || j >= n  || grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = 0;

        return 1 + dfs(grid, i+1, j, m, n) + dfs(grid, i, j+1, m, n) + dfs(grid, i-1, j, m, n) + dfs(grid, i, j-1, m, n);
    }

    
    public static int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, m, n);
                    maxCount = Math.max(maxCount, area);
                }
            }
        }

        return maxCount;
    }


    public static void main(String[] args) {
        int[][] M = {
            {1, 0, 0, 0, 1, 0, 0},
            {0, 1, 0, 0, 1, 1, 1},
            {1, 1, 0, 0, 0, 0, 0},
            {1, 0, 0, 1, 1, 0, 0},
            {1, 0, 0, 1, 0, 1, 1}};

        System.out.println(maxAreaOfIsland(M));
    }
}