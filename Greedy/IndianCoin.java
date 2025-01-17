package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class IndianCoin {
    public static void CountCoins(Integer coins[], int amount){
        Arrays.sort(coins, Comparator.reverseOrder());

        ArrayList<Integer> ans = new ArrayList<>();
        int countCoin = 0;

        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                while (coins[i] <= amount) {
                    countCoin++;
                    ans.add(coins[i]);
                    amount -= coins[i];
                }
            }
        }

        System.out.println("Max coins : " + countCoin);

        for (Integer i : ans) {
            System.out.print(i +" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Integer coins[] = {1,2,5,10,20,50,100,500,2000};
        int amount = 590;
        CountCoins(coins, amount);

        CountCoins(coins, 519);
    }
}