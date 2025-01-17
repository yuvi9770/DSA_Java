package DynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;;

public class MinNumOfRemovalToMakeMountain {
    //leetcode 1671
    public static int[] lis(int arr[]){
        int n = arr.length;
        int dp[] = new int[n];
        ArrayList<Integer> temp = new ArrayList<>();

        temp.add(arr[0]);
        dp[0] = 1;
        int len = 1;
        
        for (int i = 1; i < n; i++) {
            if (arr[i] > temp.get(temp.size()-1)) {
                temp.add(arr[i]);
                dp[i] = ++len;

            }else{
                int index = Collections.binarySearch(temp, arr[i]);
                // if the element is not present then above function will return value [-(insertion point) - 1] where it can be insert
                if (index < 0) index = -(index+1);

                temp.set(index, arr[i]);
                dp[i] = index+1;
            }
        }

        return dp;
    }


    public static int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int lis[] = lis(nums);

        for (int i = 0; i < n/2 ; i++) {
            int temp = nums[i];
            nums[i] = nums[n-1-i];
            nums[n-1-i] = temp;
        }
        
        int lds[] = lis(nums);

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if(lis[i] > 1 && lds[n-1-i] > 1){
                ans = Math.max(ans, lis[i] + lds[n-1-i]);
            }
        }

        return n - (ans - 1);
    }

    public static void main(String[] args) {
        int arr[] = {2,1,1,5,6,2,3,1};

        System.out.println(minimumMountainRemovals(arr));
    }

    public static void print(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }System.out.println();
    }
}