package DynamicProgramming;

import java.util.Arrays;

public class Tribonacci {
    //Recursion
    public static int tribo1(int n){
        if (n == 0 || n == 1) return 0;

        if (n == 2) return 1;

        return tribo1(n-1) + tribo1(n-2) + tribo1(n-3);
    }

    //Memoization
    public static int tribo2(int n, int dp[]){
        if (n == 0 || n == 1) return 0;

        if (n == 2) return 1;

        if (dp[n] != -1) return dp[n];

        return dp[n] = tribo2(n-1, dp) + tribo2(n-2, dp) + tribo2(n-3, dp);
    }
    
    //Tabulation
    public static int tribo3(int n){
        int dp[] = new int[n];

        dp[0] = dp[1] = 0;
        dp[2] = 1;

        for (int i = 3; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        // for (int i = 0; i < dp.length; i++) {
        //     System.out.print(dp[i] + " ");
        // }
        // System.out.println();

        return dp[n-1];
    }

    public static void main(String[] args) {
        int n = 10;
        // for (int i = 0; i < n; i++) {
        //     System.out.print(tribo1(i) + " ");
        // }

        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        // for (int i = 0; i < n; i++) {
        //     System.out.print(tribo2(i, dp) + " ");
        // }

        System.out.println(tribo3(n));
    }
}