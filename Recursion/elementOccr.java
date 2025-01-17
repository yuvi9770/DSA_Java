package Recursion;

public class elementOccr {
    public static void occr(int arr[], int i, int key){
        if (arr[i] == key) {
            System.out.print(i +" ");
        }
        if (i == arr.length-1) {
            return;
        }
        occr(arr, ++i, key);
    }

    public static void main(String[] args) {
        int arr[] = {1,4,2,5,23,5,2,4,5,65};
        int key = 5;
        occr(arr, 0, key);
    }
}