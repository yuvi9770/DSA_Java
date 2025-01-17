package DivideAndConquer;

public class quickSort {

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

        int pidx = partition(arr, low, high);
        sort(arr, low, pidx-1);
        sort(arr, pidx+1, high);
    }

    public static int partition(int arr[], int low, int high){
        int pivot = arr[high];
        int i = low-1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivot ; // pivot = arr[high]
        arr[high] = arr[i];
        arr[i] = temp;

        return i;
    }

    public static void main(String[] args) {
        int arr[] = {6,3,9,5,2,8,1,4};
        sort(arr, 0, arr.length-1);
        printarr(arr);
    }
}
