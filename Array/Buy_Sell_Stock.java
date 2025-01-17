package Array;

public class Buy_Sell_Stock {

    public static void Stock(int price[]){
        int buyPrice = Integer.MAX_VALUE;
        int maxprofit =  0;
        
        for (int i = 0; i < price.length; i++) {
            if (buyPrice < price[i]) {
                int profit = price[i] - buyPrice;
                maxprofit = Math.max(maxprofit, profit);
            } else {
                buyPrice = price[i];
            }
        }
        System.out.println(maxprofit);
    }
    public static void main(String[] args) {
        int price[] = {7,1,5,3,6,4}; 
        Stock(price);
    }
}