package Array.Questions;

public class SearchInRotatedArray {
    public static int search(int arr[], int target){
        int low = 0;
        int high = arr.length-1;

        while (low <= high) {
            int mid = (low + high)/2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[low] <= arr[mid]) {
                if (arr[low] <= target && target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (arr[mid] < target && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid -1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,8,9,10,11,12,0,1,2,3};
        int target =1;
        int index = search(arr, target);
        if (index == -1) {
            System.out.println("Element Not Found");
        } else {
            System.out.println("Array At index: "+ index);
        }
    }
}