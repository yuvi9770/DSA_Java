package Hashing;

import java.util.HashSet;

public class CountDistinctElement {
    
    public static int uniqueElement(int arr[]){
        HashSet<Integer> set = new HashSet<>();

        for (Integer i : arr) {
            set.add(i);
        }

        return set.size();
    }

    public static void main(String[] args) {
        int nums[] = {4,3,2,5,6,7,3,4,2,1};
        System.out.println(uniqueElement(nums));
    }
}