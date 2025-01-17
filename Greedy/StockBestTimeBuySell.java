package Greedy;

public class StockBestTimeBuySell {
    public static int stock(int price[]){
        int maxProfit = 0;
        int buy = price[0];
        int n = price.length;

        for (int i = 1; i < n; i++) {
            if (buy > price[i]) {
                buy = price[i];

            }else{
                int profit = price[i] - buy;
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        
        return maxProfit;
    }

    public static void main(String[] args) {
        int p1[] = {7,6,4,3,1};
        System.out.println(stock(p1));

        int p2[] = {7,1,5,3,6,4};
        System.out.println(stock(p2));
    }
}