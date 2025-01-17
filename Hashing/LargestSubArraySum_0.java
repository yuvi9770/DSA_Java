package Hashing;

import java.util.HashMap;

public class LargestSubArraySum_0 {

    public static int largeSubArr(int arr[]){
        HashMap<Integer, Integer> map = new HashMap<>(); // (sum, idx)
        int sum = 0;
        int len = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (map.containsKey(sum)) {
                len = Math.max(len, i - map.get(sum));

            } else {
                map.put(sum, i);
            }
        }

        return len;
    }

    public static void main(String[] args) {
        int arr[] = {15,-2,2,-8,1,7,10};
        System.out.println(largeSubArr(arr));
    }
}