package Arraylist;

import java.util.HashMap;
import java.util.Map;

public class Most_Freq_Num_Follow_Key {
    
    public static int mostFrequent(int[] nums, int key) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == key) {
                map.put(nums[i+1], map.getOrDefault(nums[i+1], 0)+1);
            }
        }
        
        int maxKey = -1;
        int maxFreq = 0;

        for (Map.Entry<Integer, Integer> i : map.entrySet()) {
            if(i.getValue() > maxFreq){
                maxFreq = i.getValue();
                maxKey = i.getKey();
            }
        }
        return maxKey;
    }

    public static void main(String[] args) {
        int arr[] = {1,100,200,1,100};
        int arr2[] = {2,2,2,2,3};
        System.out.println(mostFrequent(arr,1));
        System.out.println(mostFrequent(arr2,2));
    }
}