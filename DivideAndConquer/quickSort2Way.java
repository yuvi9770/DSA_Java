package DivideAndConquer;

public class quickSort2Way {
    public static void printarr(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void sort(int arr[], int low, int high){
        if (low < high) {
            int pidx = partition(arr, low, high);
            sort(arr, low, pidx-1);
            sort(arr, pidx+1, high);
        }
    }

    public static int partition(int arr[], int low, int high){
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (arr[i] <= pivot && i <= high-1) {
                i++;
            }

            while (arr[j] > pivot && j >= low+1) {
                j--;
            }

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        int temp = pivot;
        arr[low] = arr[j];
        arr[j] = temp;

        return j;
    }

    public static void main(String[] args) {
        int arr[] = {6,3,9,5,2,8,1,4};
        sort(arr, 0, arr.length-1);
        printarr(arr);
    }
}