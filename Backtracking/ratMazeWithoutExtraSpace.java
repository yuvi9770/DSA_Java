package Backtracking;

import java.util.ArrayList;

public class ratMazeWithoutExtraSpace {

    public static boolean isSafe(int maze[][], int i, int j, int n, int m){
        if ((i >= 0 && i < n) && (j >= 0 && j < m) && (maze[i][j] == 1)) {
            return true; 
        }
        return false;
    }

    public static void path(int maze[][], int i, int j, int n, int m, ArrayList <String> ans, String move){
        if (i == n-1 && j == m-1 && maze[i][j]== 1) {
            ans.add(move);
            return;
        }

        if (isSafe(maze, i, j, n, m)) {
            maze[i][j] = -1;

            // Down
            path(maze, i+1, j, n, m,ans, move + 'D');
            // Left
            path(maze, i, j-1, n, m,ans, move + 'L');
            // Right
            path(maze, i, j+1, n, m,ans, move + 'R');
            // Up
            path(maze, i-1, j, n, m,ans, move + 'U');
            
            maze[i][j] = 1;
        }
    }

    public static ArrayList < String > solve(int maze[][], int n, int m){
        ArrayList < String > ans = new ArrayList < > ();
        
        if (maze[0][0] == 1){}
        path(maze, 0, 0, n, m, ans, "");
        return ans;
    }

    public static void main(String args[]) {
        int maze[][] = {
            {1, 0, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 1}
        };
        
        int n = maze.length;
        int m = maze[0].length;

        ArrayList < String > res = solve(maze,n,m);
        if (res.size() > 0) {
            for (int i = 0; i < res.size(); i++){
                System.out.print(res.get(i) + " ");
            }
        } else {
            System.out.println(-1);
        }
    }

}