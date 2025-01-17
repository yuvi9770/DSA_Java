package DynamicProgramming;

public class CoinChange {
    //Recursion
    public static int change1(int i, int coins[], int sum){
        if (sum == 0) return 1;

        if (i == coins.length) return 0;

        if (sum < coins[i]) {
            return change1(i+1, coins, sum);
        }

        int take = change1(i, coins, sum - coins[i]);
        int skip = change1(i+1, coins, sum);

        return take + skip;
    }


    //Tabulation
    public static int change(int coins[], int sum){
        int n = coins.length;
        int dp[][] = new int[n+1][sum+1];

        for (int i = 0; i < n+1; i++) dp[i][0] = 1;

        for (int i = 1; i < dp.length; i++) {
            int c = coins[i-1];

            for (int j = 1; j < dp[0].length; j++) {
                
                if (c <= j) {
                    dp[i][j] = dp[i][j - c] + dp[i-1][j];

                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        // print(dp);

        return dp[n][sum];
    }


    // using tabulation with 1-D array space
    public static int change2(int coins[], int sum){
        int n = coins.length;
        int dp[] = new int[sum+1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            int cn = coins[i];

            for (int j = cn; j <= sum; j++) {
                dp[j] = dp[j] + dp[j-cn];
            }
        }

        return dp[sum];
    }

    public static void main(String[] args) {
        int coin[] = {2,5,3,6};
        int sum = 10;

        System.out.println(change1(0, coin, sum));
        
        // System.out.println(change(coin, sum));

        System.out.println(change2(coin, sum));
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