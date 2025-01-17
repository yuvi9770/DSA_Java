package Arraylist;

import java.util.ArrayList;
import java.util.Arrays;

public class storeWater_2Pointer {
    public static int water(ArrayList<Integer> height){
        int maxWater = 0;
        int i = 0;
        int j = height.size()-1;

        while (i < j) {
            // calculate water
            int ht = Math.min(height.get(i), height.get(j));
            int width = j-i;
            int currWater = ht*width;
            maxWater = Math.max(maxWater, currWater);

            // update pointer
            if (height.get(i) <= height.get(j)) {
                i++;
            } else {
                j--;
            }
        }
 
        return maxWater;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,8,6,2,5,4,8,3,7));
        System.out.println(water(list));
    }
}