package Array;

public class ReverseArray {
    public static void Reverse(int arr[]){
        int n = arr.length;
        for (int i = 0; i < n/2; i++) {
            int temp = arr[i];
            arr[i] = arr[n-i-1];
            arr[n-i-1] = temp;
        }
        System.out.print("Reverse Array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {2,6,7,4,1};
        System.out.print("Original Array: " );
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        Reverse(arr);
    }
}