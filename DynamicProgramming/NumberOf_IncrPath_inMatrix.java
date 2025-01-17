package DynamicProgramming;

public class NumberOf_IncrPath_inMatrix {
    // Graph + DP (leetcode - 2328)

    static int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    static long MOD = (long) (1e9 + 7);

    public static int dfs(int matrix[][], int n, int m, int i, int j, int dp[][]){

        if (dp[i][j] > 0) return dp[i][j];

        int ans = 1;

        for(int k[] : dir){
            int x = i + k[0], y = j + k[1];

            if (x >= 0 && y >= 0 && x < n && y < m && matrix[x][y] < matrix[i][j]) {
                ans = (ans + dfs(matrix, n, m, x, y, dp)) % (int)MOD;
            }
        }

        return dp[i][j] = ans;
    }

    public static int path(int matrix[][]){
        if (matrix == null || matrix.length == 0) return 0;

        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[n][m];

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result = (result + dfs(matrix, n, m, i, j, dp)) % (int)MOD;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        int matrix[][] = {{1,1},{3,4}};
        System.out.println(path(matrix));
    }
}