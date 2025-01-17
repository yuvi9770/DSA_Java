package DivideAndConquer;

public class mergeSort {

    public static void printarr(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void sort(int arr[], int low, int high){
        if (low >= high) {
            return;
        }

        int mid = low + ((high - low) /2);
        sort(arr, low, mid); // left part
        sort(arr, mid+1, high); // right part

        merge(arr, low, mid, high); 
    }

    public static void merge(int arr[], int low, int mid, int high){
        int temp[] = new int[high-low+1];
        int i = low; 
        int j = mid+1;
        int k = 0;

        while (i <= mid && j<= high) {

            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k++] = arr[i++]; 
        }

        while (j <= high) {
            temp[k++] = arr[j++];
        }

        for (int x = low; x <= high; x++) {
            arr[x] = temp[x-low];
        }
    }

    public static void main(String[] args) {
        int arr[] = {6,3,9,5,2,8,1};
        sort(arr, 0, arr.length-1);
        printarr(arr);
    }
}