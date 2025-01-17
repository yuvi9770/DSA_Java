package Hashing;

import java.util.HashMap;

public class MajorityElement {
    public static void majorElement(int arr[]){

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (int key : map.keySet()) {
            if (map.get(key) > arr.length/3) {
                System.out.print(key + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {1,3,2,5,1,3,1,5,1};
        majorElement(arr);

        majorElement(new int[] {1,2});
    }
}