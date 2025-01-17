package Arraylist;

import java.util.ArrayList;
import java.util.Arrays;

public class Most_Freq_Num_usingLoop_AL {
    public static void usingloop(ArrayList<Integer> nums, int key){
        if (nums.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        int maxEle = Integer.MIN_VALUE;
        for (int i : nums) {
            maxEle = Math.max(maxEle, i);
        }

        int res[] = new int[maxEle+1];

        for (int i = 0; i < nums.size()-1; i++) {
            if (nums.get(i) == key) {
                res[nums.get(i+1)]++;
            }
        }

        int maxKey = -1;
        int maxFreq = 0;
        
        for (int i = 0; i <= maxEle; i++) {
            if (res[i] > maxFreq) {
                maxFreq = res[i];
                maxKey = i;
            }
        }
        System.out.println(maxKey);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList());
        usingloop(arr, 1);
    }
}
