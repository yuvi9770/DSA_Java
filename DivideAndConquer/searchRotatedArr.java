package DivideAndConquer;

public class searchRotatedArr {
    public static int search(int arr[], int targer, int low, int high){
        if (low > high) {
            return -1;
        }

        int mid = (low + high)/2;
        
        if (arr[mid] == targer) {
            return mid;
        }

        if (arr[low] <= arr[mid]) {
            if (arr[low] <= targer && targer <= arr[mid]) {
                return search(arr, targer, low, mid - 1);
            } else {
                return search(arr, targer, mid + 1, high);
            }
        } else {
            if (arr[mid] <= targer && targer <= arr[high]) {
                return search(arr, targer, mid + 1, high);
            } else {
                return search(arr, targer, low, mid - 1);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {4,5,6,7,0,1,2,3};
        int targer = 0;
        System.out.println(search(arr, targer, 0, arr.length-1));
    }
}