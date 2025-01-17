package Backtracking;

public class RatMaze4dir {
    public static void printArr(int arr[][],int n, int m){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static boolean isSafe(int maze[][], int i, int j, int n, int m, int vis[][]){
        if ((i >= 0 && i < n) && (j >= 0 && j < m) && (maze[i][j] == 1) && (vis[i][j] == 0)) {
            return true; 
        }
        return false;
    }

    public static boolean path(int maze[][], int i, int j, int n, int m, int vis[][]){
        if (i == n-1 && j == m-1 && maze[i][j]== 1) {
            vis[i][j] = 1;
            return true;
        }

        if (isSafe(maze, i, j, n, m, vis)) {
            vis[i][j] = 1;

            // Down
            if (path(maze, i+1, j, n, m, vis)) {
                return true;
            }
            // Left
            if (path(maze, i, j-1, n, m, vis)) {
                return true;
            }
            // Right
            if (path(maze, i, j+1, n, m, vis)) {
                return true;
            }
            // Up
            if (path(maze, i-1, j, n, m, vis)) {
                return true;
            }

            vis[i][j] = 0;
        }

        return false;
    }

    public static void solve(int maze[][], int n, int m){
        int vis[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
              vis[i][j] = 0;
            }
        }

        if ((maze[0][0] == 1) && path(maze, 0, 0, n, m, vis)) {
            System.out.println("Sol possible");
            printArr(vis, n, m);
            
        } else {
            System.out.println("Sol not possible");
        }
    }

    public static void main(String args[]) {
        int maze[][] = {
            {1, 0, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 1}
        };
        
        int n = maze.length;
        int m = maze[0].length;
        solve(maze,n,m);
    }
}