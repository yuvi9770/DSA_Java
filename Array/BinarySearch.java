package Array;

public class BinarySearch {
    public static int binary_Search(int arr[], int key){
        int start = 0;
        int end = arr.length-1;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            else if(arr[mid] > key){
                end = mid -1;
            }
            else{
                start = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {2,4,6,7,9,14,27,36,44,49,76,145};
        int key = 76;
        int found = binary_Search(arr, key);

        if (found == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + found);
        }
    }
}