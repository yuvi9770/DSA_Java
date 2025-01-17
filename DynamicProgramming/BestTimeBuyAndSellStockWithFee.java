package DynamicProgramming;

import java.util.Arrays;

public class BestTimeBuyAndSellStockWithFee {
    //Recursion
    public static int profit1(int prices[], int day, int n, boolean buy, int fee){
        if (day >= n) return 0;

        int profit = 0;

        if (buy) {
            int take = profit1(prices, day+1, n, false, fee) - prices[day];
            int notTake = profit1(prices, day+1, n, true, fee);

            profit = Math.max(profit, Math.max(take, notTake));
            
        } else {
            int sell = profit1(prices, day+1, n, true, fee) + prices[day] - fee;
            int notSell = profit1(prices, day+1, n, false, fee);

            profit = Math.max(profit, Math.max(sell, notSell));
            
        }

        return profit;
    }


    //Memoization
    public static int profit2(int prices[], int day, int n, boolean buy, int fee, int dp[][]){
        if (day >= n) return 0;

        int buyidx = buy ? 1:0;
        if (dp[day][buyidx] != -1) return dp[day][buyidx];

        int profit = 0;

        if (buy) {
            int take = profit2(prices, day+1, n, false, fee, dp) - prices[day];
            int notTake = profit2(prices, day+1, n, true, fee, dp);

            profit = Math.max(profit, Math.max(take, notTake));
            
        } else {
            int sell = profit2(prices, day+1, n, true, fee, dp) + prices[day] - fee;
            int notSell = profit2(prices, day+1, n, false, fee, dp);

            profit = Math.max(profit, Math.max(sell, notSell));
            
        }

        return dp[day][buyidx] = profit;
    }


    //Tabulation
    public static int profit3(int prices[], int fee){
        int n = prices.length;

        int buy = -prices[0];
        int sell = 0;

        for (int i = 1; i < n; i++) {
            buy = Math.max(buy, sell - prices[i]);
            sell = Math.max(sell, buy + prices[i] - fee);
        }

        return sell;
    }

    public static void main(String[] args) {
        int prices[] = {6,1,7,2,8,4};
        int fee = 2;

        // System.out.println(profit1(prices, 0, prices.length, true, fee));
        int dp[][] = new int[prices.length][2];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(profit2(prices, 0, prices.length, true, fee, dp));


        System.out.println(profit3(prices, fee));
        
    }
}