package DynamicProgramming;

public class fibonacci {
    //Recursion
    public static int fib(int n){
        if (n==0 || n==1) return n;

        return fib(n-1) + fib(n-2);
    }

    //Memoization
    public static int fib2(int n, int dp[]){
        if (n==0 || n==1) return n;

        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = fib2(n-1, dp) + fib2(n-2, dp);
        return dp[n];
    }

    //Tabulation
    public static int fib3(int n){
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 6;
        int dp[] = new int[n+1];
        System.out.println(fib2(n, dp));

        // System.out.println(fib3(n));

        // System.out.println(fib(n));
    }
}
    //Recursion
    //Memoization
    //Tabulation