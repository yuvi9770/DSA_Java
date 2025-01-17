package DynamicProgramming;

public class RodCutting {
    
    public static int maxProfit(int price[], int rodLen[], int totalRod){
        int n = price.length;
        int dp[][] = new int[n+1][totalRod+1];

        for (int i = 1; i < dp.length; i++) {
            int val = price[i-1], len = rodLen[i-1];

            for (int j = 1; j < dp[0].length; j++) {
                if (len <= j) {
                    dp[i][j] = Math.max(val + dp[i][j-len], dp[i-1][j]);

                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        // print(dp);

        return dp[n][totalRod];
    }

    // using tabulation with 1-D array space
    public static int maxProfit2(int price[], int rodLen[], int totalRod){
        int n = price.length;
        int dp[] = new int[totalRod+1];

        for (int i = 0; i < n; i++) {
            int val = price[i], len = rodLen[i];

            for (int j = len; j <= totalRod; j++) {
                dp[j] = Math.max(dp[j], val + dp[j-len]);
            }
        }

        return dp[totalRod];
    }

    public static void main(String[] args) {
        int rodLen[] = {1,2,3,4,5,6,7,8};
        int price[] = {1,5,8,9,10,17,17,20};
        int totalRod = 8;

        // System.out.println(maxProfit(price, rodLen, totalRod));

        System.out.println(maxProfit2(price, rodLen, totalRod));
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