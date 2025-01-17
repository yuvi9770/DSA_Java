package Sorting;

public class CountSortNegative {
    public static void count(int arr[]){
        int n = arr.length;
        int max = 0;
        int min = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        int count[] = new int[max+1-min];
        for (int i = 0; i < n; i++) {
            count[arr[i] - min]++;
        }
       
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i-1];
        }

        int b[] = new int[n];
        for (int i = n-1; i >= 0; i--) {
            b[--count[arr[i]- min] ] = arr[i];
        }

        for (int i : b) {
            System.out.print(i+" ");
        }
    }
    public static void main(String[] args) {
        int arr[] ={1,4,3,0,1,-5,2,-3,1,5};
        count(arr);
    }
}