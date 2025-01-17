package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void fraction(int val[], int weight[], int capacity){
        double ratio[][] = new double[val.length][2];
        // 0th - idx; 1st - ratio
        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = (double)val[i]/weight[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int finalVal = 0;
        for (int i = ratio.length-1; i >= 0; i--) {
            int idx = (int)ratio[i][0];

            if (capacity >= weight[idx]) { // include full item
                finalVal += val[idx];
                capacity -= weight[idx];
            }else{
                // include fractional item
                finalVal += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }
        System.out.println("finalVal : " + finalVal);
    }

    public static void main(String[] args) {
        int val[] = {60,100,120};
        int weight[] = {10,20,30};
        int capacity = 50;
        fraction(val, weight, capacity);
    }
}