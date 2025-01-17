package DynamicProgramming;

public class Longest_IncrPath_inMatrix {
    // Graph + DP (leetcode - 329)

    public static int dfs(int matrix[][], int n, int m, int i, int j, int dp[][]){
        if (dp[i][j] > 0) return dp[i][j];

        int maxlen = 1;

        for (int k[] : dir) {
            int x = i + k[0], y = j + k[1];
            // both way are correct matrix[x][y] > matrix[i][j] and matrix[x][y] < matrix[i][j]
            if (x >= 0 && y >= 0 && x < n && y < m && matrix[x][y] > matrix[i][j]) {
                maxlen = Math.max(maxlen, 1 + dfs(matrix, n, m, x, y, dp));
            }
        }

        return dp[i][j] = maxlen;
    }

    static int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};

    public static int path(int matrix[][]){
        if (matrix == null || matrix.length == 0) return 0;

        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[n][m];

        int longestpath = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                longestpath = Math.max(longestpath, dfs(matrix, n, m, i, j, dp));
            }
        }
        print(dp);

        return longestpath;
    }

    public static void main(String[] args) {
        int matrix[][] = {{9,9,4},{6,6,8},{2,1,1}};
        System.out.println(path(matrix));
    }

    public static void print(int dp[][]){
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}