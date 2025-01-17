package Sorting;

public class InsertionSort {
    public static void Insertion(int arr[]){
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i-1;
            while (j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
                
            }
            arr[j+1] = key; 
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] ={5,4,1,3,2};
        Insertion(arr);
    }
}