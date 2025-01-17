package Hashing;

import java.util.HashSet;

public class UnionAndIntersection {

    public static void Union(int arr1[], int arr2[]){
        HashSet<Integer> set = new HashSet<>();
        for (Integer i : arr1) {
            set.add(i);
        }

        for (Integer i : arr2) {
            set.add(i);
        }
        
        System.out.println("Union : " + set.size());
        System.out.println(set);
    }

    public static void Intersect(int arr1[], int arr2[]){
        HashSet<Integer> set = new HashSet<>();
        int count = 0;

        for (Integer i : arr1) {
            set.add(i);
        }

        for (Integer i : arr2) {
            if (set.contains(i)) {
                count++;
                set.remove(i);
                // System.out.println(i);
            }
        }
        System.out.println("Intersection : " + count);
    }

    public static void main(String[] args) {
        int arr1[] = {7,3,9};
        int arr2[] = {6,3,9,2,9,4};

        Union(arr1, arr2);
        Intersect(arr1, arr2);
    }
}