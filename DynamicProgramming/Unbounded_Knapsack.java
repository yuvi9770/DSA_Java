package DynamicProgramming;

public class Unbounded_Knapsack {

    public static void print(int dp[][]){
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int unBounded(int val[], int wt[], int W){
        int n = val.length;
        int dp[][] = new int[n+1][W+1];

        for (int i = 1; i < dp.length; i++) {
            int v = val[i-1], w = wt[i-1];

            for (int j = 1; j < dp[0].length; j++) {
                if (w <= j) {
                    int incP = v + dp[i][j-w]; // (i-1 -> i)
                    int excP = dp[i-1][j];

                    dp[i][j] = Math.max(incP, excP);
                    
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        // print(dp);

        return dp[n][W];
    }

    // using tabulation with 1-D array space
    public static int unBounded2(int val[], int wt[], int W){
        int n = val.length;
        int dp[] = new int[W+1];

        for (int i = 0; i < n; i++) {

            for (int j = wt[i]; j <= W; j++) {
                dp[j] = Math.max(dp[j], val[i] + dp[j - wt[i]]);   
            }
        }

        return dp[W];
    }

    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;

        // System.out.println(unBounded(val, wt, W));

        System.out.println(unBounded2(val, wt, W));
    }
}