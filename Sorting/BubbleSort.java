package Sorting;

public class BubbleSort {

    public static void bubble(int arr[]){
        int n=arr.length;
        
        for (int i = n-1; i > 0; i--) {
            boolean check = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    check = true;
                }
            }
            if (check==false) { 
                break;
            }
        }

        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
    public static void main(String[] args) {
        int arr[] ={5,3,4,2,1};
        bubble(arr);
    }
}