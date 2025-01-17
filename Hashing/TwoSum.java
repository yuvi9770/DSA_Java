package Hashing;

import java.util.HashMap;

public class TwoSum {

    public static int[] tSum(int arr[], int target){
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int diff = target - arr[i];

            if (map.containsKey(diff)) {
                return new int[] {i,map.get(diff)};
            }
            map.put(arr[i], i);
            
        }

        return new int[] {0,0};
    }

    public static void print(int res[]){
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {2,7,11,15};
        int target = 9;
        int res[] = tSum(arr, target);
        print(res);

        int res2[] = tSum(new int[] {3,2,4}, 6);
        print(res2);   
    }
}