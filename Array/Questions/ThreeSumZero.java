package Array.Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ThreeSumZero {

    public static List<List<Integer>> UsingTwoPointer(int arr[]){
        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i] == arr[i-1]) {
                continue;
            }
            int j = i+1;
            int k = n-1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];

                if (sum == 0) {
                    result.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    j++;
                    k--;
                    while (j < k && arr[j] == arr[j - 1]) j++;
                    while (j < k && arr[k] == arr[k + 1]) k--; 
                }
                else if (sum < 0) {
                    j++;
                }
                else if (sum > 0) {
                   k--; 
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> UsingHashSet(int arr[]){
        List<List<Integer>> result = new ArrayList<>();
        HashSet <Integer> set = new HashSet<>();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length-2; i++) {
            if (i > 0 && arr[i] == arr[i-1]) {
                continue;
            }
            set.clear();
            for (int j = i+1; j < arr.length; j++) {
                
                int z = -(arr[i]+arr[j]);
                if (set.contains(z)) {
                    result.add(Arrays.asList(arr[i],z ,arr[j]));

                    while (j + 1 < arr.length && arr[j] == arr[j + 1]) {
                        j++;
                    }
                }else {
                    set.add(arr[j]);
                }
            }
        }
        return result;
    }

    public static void UsingHashMap(int arr[]){
        HashMap <Integer, Integer> map = new HashMap<>();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length-2; i++) {
            if (i > 0 && arr[i] == arr[i-1]) {
                continue;
            }
            map.clear();
            for (int j = i+1; j < arr.length; j++) {
                
                int z = -(arr[i]+arr[j]);
                if (map.containsKey(z)) {
                    System.out.println(arr[i]  +" "+  z +" "+ arr[j]);

                    while (j + 1 < arr.length && arr[j] == arr[j + 1]) {
                        j++;
                    }
                }else {
                    map.put(arr[j],j);
                }
            }
        }
    }

    public static void Usingloop(int arr[]){
        Arrays.sort(arr);
        for (int i = 0; i < arr.length-2; i++) {
            if (i > 0 && arr[i] == arr[i-1]) {
                continue;
            }

            for (int j = i+1; j < arr.length-1; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) {
                    continue;
                }      

                for (int k = j+1; k < arr.length; k++) {
                    if (k > j + 1 && arr[k] == arr[k - 1]) {
                        continue;
                    }   
                    
                    if ((arr[i] + arr[j] + arr[k]) == 0) {
                        System.out.println(arr[i] +" "+ arr[j] +" "+ arr[k]);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {-1,0,1,2,-1,1,-4};
        
        // Usingloop(arr);
        // UsingHashMap(arr);
        // List<List<Integer>> triple = UsingHashSet(arr);
        List<List<Integer>> triple = UsingTwoPointer(arr); 

        for (List<Integer> list : triple) {
            System.out.println(list);
        }
    }
}