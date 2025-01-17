package Array.Questions;

public class Stock {
    public static void MaxProfit(int price[]){
        int maxprofit = 0;
        int buyStock = Integer.MAX_VALUE;

        for (int i = 0; i < price.length; i++) {
            if (buyStock > price[i]) {
                buyStock = price[i];
            } else {
                int profit = price[i] - buyStock;
                maxprofit = Math.max(maxprofit,profit);
            }
        }
        System.out.println("Max profit is: " + maxprofit);
    }
    public static void main(String[] args) {
        int price [] ={7,1,5,3,6,4};
        MaxProfit(price);
    }
}