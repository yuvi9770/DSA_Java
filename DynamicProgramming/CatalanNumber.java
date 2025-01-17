package DynamicProgramming;

import java.util.Arrays;

public class CatalanNumber {
    //Recursion
    public static int catal1(int n){
        if (n == 0 || n == 1) return 1;

        int ans = 0; //Cn
        for (int i = 0; i < n; i++) {
            ans += catal1(i) * catal1(n - i -1 );
        }

        return ans;
    }

    //Memoization
    public static int catal2(int n, int dp[]){
        if (n == 0 || n == 1) return 1;

        if (dp[n] != -1) return dp[n];

        int ans = 0; //Cn
        for (int i = 0; i < n; i++) {
            ans += catal2(i, dp) * catal2(n-i-1, dp);
        }

        return dp[n] = ans;
    }

    //Tabulation
    public static int catal3(int n){
        int dp[] = new int[n+1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i-j-1];
            }
        }

        return dp[n];
    }


    public static void main(String[] args) {
        int n = 4;
        // System.out.println(catal1(n));

        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        // System.out.println(catal2(n, dp));

        System.out.println(catal3(n));
    }
}