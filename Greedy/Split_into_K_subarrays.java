package Greedy;
// Split into K subarrays to minimize the maximum sum of all subarrays

public class Split_into_K_subarrays {
    public static int Num_of_subArray_with_sum_as_mid(int arr[], int mid){
        int sum = 0;
        int count = 1;

        for (int i = 0; i < arr.length; i++) {
            if ((sum + arr[i]) > mid) {
                sum = arr[i];
                count++;
                
            }else{
                sum += arr[i];
            }
        }
        return count;
    }

    public static int SplitArr(int arr[], int k){
        int n = arr.length;
        int low = 0; // max num
        int high = 0; // sum of num

        for (int i : arr) {
            high += i;
            low = low > i ? low : i; //Math.max(low, i);
        }

        if (k == 1) return high;
        if (k == n) return low;

        int ans = low;
        while (low <= high) {
            int mid = (low+high)/2;

            int count = Num_of_subArray_with_sum_as_mid(arr, mid);

            if (count > k) {
                low = mid+1;
                
            } else {
                ans = mid;
                high = mid-1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {1,1,2};
        System.out.println(SplitArr(arr, 2));

        System.out.println(SplitArr(new int[] {3,6,2,8,4}, 2));

        System.out.println(SplitArr(new int[] {3,6,2,8,4}, 3));
    }
}