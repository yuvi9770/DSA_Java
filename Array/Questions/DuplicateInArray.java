package Array.Questions;

import java.util.HashSet;

public class DuplicateInArray {

    public static boolean Duplicate(int arr[]){
        
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean Duplicate_Set(int arr[]){
        // This method have o(n) complexity
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                return true;
            } else {
                set.add(arr[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] ={1,2,3,5,8,6,1};
        //System.out.println(Duplicate(arr));
        System.out.println(Duplicate_Set(arr));
    }
}