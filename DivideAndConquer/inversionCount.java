package DivideAndConquer;

public class inversionCount {
    public static int merge(int nums[], int low, int mid, int high){
        int inCount = 0;

        int temp[] = new int[high-low+1];
        int i = low;
        int j = mid+1;
        int k =0;

        while (i <= mid && j<= high) {

            if (nums[i] <= nums[j]) {
                temp[k] = nums[i];
                i++;
            } else {
                temp[k] = nums[j];
                inCount = inCount + (mid - i + 1);
                j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k++] = nums[i++]; 
        }

        while (j <= high) {
            temp[k++] = nums[j++];
        }

        for (int x = low; x <= high; x++) {
            nums[x] = temp[x-low];
        }

        return inCount;
    }


    public static int sort(int nums[], int low, int high){
        int count = 0 ;

        if (low >= high) {
            return 0;
        }

        int mid = (low + high)/2;

        count += sort(nums, low, mid);
        count += sort(nums, mid+1, high);
        count += merge(nums, low, mid, high);
        
        return count;
    }

    public static void main(String[] args) {
        int nums[] = {1,20,6,4,5};
        System.out.println(sort(nums, 0, nums.length-1));
    }
}