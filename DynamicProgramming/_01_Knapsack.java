package DynamicProgramming;

import java.util.Arrays;

public class _01_Knapsack {
    //Recursion
    public static int kSack(int val[], int wt[], int W, int n){
        if (W == 0 || n == 0) return 0;

        if (wt[n-1] <= W) {
            int ans1 = val[n-1] + kSack(val, wt, W - wt[n-1], n-1); // include

            int ans2 = kSack(val, wt, W, n-1); // exclude

            return Math.max(ans1, ans2);
            
        } else {
            return kSack(val, wt, W, n-1);
        }
    }
    
    //Memoization
    public static int kSack2(int val[], int wt[], int W, int n, int dp[][]){
        if (W == 0 || n == 0) return 0;

        if (dp[n][W] != -1) return dp[n][W];

        if (wt[n-1] <= W) {
            int ans1 = val[n-1] + kSack2(val, wt, W - wt[n-1], n-1, dp); // include

            int ans2 = kSack2(val, wt, W, n-1, dp); // exclude

            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
            
        } else {
            dp[n][W] = kSack2(val, wt, W, n-1, dp);
            return dp[n][W];
        }
    }
    
    //Tabulation
    public static int kSack3(int val[], int wt[], int W){
        int n = val.length;
        int dp[][] = new int[n+1][W+1];

        for (int i = 1; i < dp.length; i++) {
            int v = val[i-1], w = wt[i-1];
            
            for (int j = 1; j < dp[0].length; j++){

                if (w <= j) {
                    int incProfit = v + dp[i-1][j-w];
                    int excProfit = dp[i-1][j];

                    dp[i][j] = Math.max(incProfit, excProfit);

                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        // print(dp);
        return dp[n][W];
    }

    // using tabulation with 1-D array space
    public static int kOPti(int val[], int wt[], int W){
        int n = val.length;
        int dp[] = new int[W+1];

        for (int i = 0; i < n; i++) {
            for (int j = W; j >= wt[i]; j--) {
                dp[j] = Math.max(dp[j], val[i] + dp[j-wt[i]]);
            }
            // print(dp);
        }
        return dp[W];
    }

    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;

        int dp[][] = new int[val.length+1][W+1];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        // System.out.println(kSack(val, wt, W, val.length ));

        // System.out.println(kSack2(val, wt, W, val.length, dp));

        System.out.println(kSack3(val, wt, W));

        System.out.println(kOPti(val, wt, W));
    }

    public static void print(int dp[]){
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
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