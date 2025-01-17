package Arraylist;

import java.util.ArrayList;
import java.util.Arrays;

public class storeWater_bruteForce {
    public static int water(ArrayList<Integer> height){
        int maxWater = 0;

        for (int i = 0; i < height.size(); i++) {
            for (int j = i+1; j < height.size(); j++) {
                int ht = Math.min(height.get(i), height.get(j));
                int width = j-i;
                int currWater = ht * width;

                maxWater = Math.max(maxWater, currWater);
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,8,6,2,5,4,8,3,7));
        System.out.println(water(list));
    }
}