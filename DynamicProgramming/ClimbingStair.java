package DynamicProgramming;

import java.util.Arrays;

public class ClimbingStair {
    //Recursion
    public static int ways(int n){
        if (n < 0) return 0;
        if (n == 0) return 1;
        
        return ways(n-1) + ways(n-2);
    }

    //Memoization
    public static int ways2(int n, int dp[]){
        if (n == 0) return 1;
        if (n < 0) return 0;
        
        if (dp[n] != -1){
            return dp[n];
        }
        
        dp[n] = ways2(n-1, dp) + ways2(n-2, dp);
        return dp[n];
    }

    //Tabulation
    public static int ways3(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            if(i == 1) dp[i]= dp[i-1];

            else dp[i]= dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);

        // System.out.println(ways(n));

        // System.out.println(ways2(n, dp));

        System.out.println(ways3(n));
    }
}