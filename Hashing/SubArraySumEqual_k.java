package Hashing;

import java.util.HashMap;

public class SubArraySumEqual_k {

    public static int SubArr(int arr[], int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0 ;
        int count = 0;
        map.put(0, 1);
        
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (map.containsKey(sum-k)) {
                count += map.get(sum-k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int arr[] = {10,2,-2,-20,10};
        System.out.println(SubArr(arr, -10));

        System.out.println(SubArr(new int[] {1,2,3}, 3));
    }
}