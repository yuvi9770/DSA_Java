package DivideAndConquer;

public class MajorityElementMergeSort {
    public static int count(int nums[], int num, int low, int high){
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    public static int majority(int nums[],int low, int high){
        if (low == high) {
            return nums[low];
        }

        int mid = (low+high)/2;
        int left = majority(nums, low, mid);
        int right = majority(nums, mid+1, high);

        if (left == right) {
            return left;
        }

        int leftCount = count(nums, left, low, high);
        int rightCount = count(nums, right, low, high);


        return leftCount > rightCount ? left : right;
    }
    public static void main(String[] args) {
        int nums[] = {2,2,1,1,1,2,2,2};
        System.out.println(majority(nums, 0, nums.length-1));
    }
}