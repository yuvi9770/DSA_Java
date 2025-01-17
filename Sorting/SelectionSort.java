package Sorting;

public class SelectionSort {
    public static void selection(int arr[]){
        int n=arr.length;
        
        for (int i = 0; i < n-1; i++) {
            int minipos = i;
            for (int j = i+1; j < n; j++) {
                if (arr[minipos] > arr[j]) {
                    minipos = j;
                }
            }
            if (minipos != i) {
                int temp = arr[minipos];
                arr[minipos] = arr[i];
                arr[i] = temp;
            }
        }
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
    public static void main(String[] args) {
        int arr[] ={5,4,1,3,2};
        selection(arr);
    }
}