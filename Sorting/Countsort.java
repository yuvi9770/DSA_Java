package Sorting;

public class Countsort {
    public static void count(int arr[]){
        int n = arr.length;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        int count[] = new int[max+1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i-1];
        }
        // use extra space
        int b[] = new int[n];
        for (int i = n-1; i >= 0; i--) {
            b[--count[arr[i]]] = arr[i];
        }

        for (int i : b) {
            System.out.print(i+" ");
        }
    }


    public static void CountingSort(int arr[]){
        int n = arr.length;
        int Max = 0;
        for (int i = 0; i < n; i++) {
            Max= Math.max(Max, arr[i]);
        }

        int Count[] = new int[Max+1];
        for (int i = 0; i < n; i++) {
            Count[arr[i]]++;
        }

        int j = 0;
        for (int i = 0; i < Count.length; i++) {
            while (Count[i] > 0) {
                arr[j] = i;
                j++;
                Count[i]--;
            }
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    public static void main(String[] args) {
        int arr[] ={1,6,5,1,6,1,2,1,6,3,2,6};
        // CountingSort(arr);
        count(arr);
    }
}