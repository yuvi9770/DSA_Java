package DynamicProgramming;

import java.util.Arrays;

public class HouseRobber {
    //Recursion
    public static int solve(int[] nums, int i){
        if (i >= nums.length) return 0;

        int take = nums[i] + solve(nums, i+2);
        int notTake = solve(nums, i+1);

        return Math.max(take, notTake);
    }
    
    //Memoization
    public static int solve2(int[] nums, int i, int dp[]){
        if (i >= nums.length) return 0;

        if (dp[i] != -1) return dp[i];

        int take = nums[i] + solve2(nums, i+2, dp);
        int notTake = solve2(nums, i+1, dp);

        return dp[i] = Math.max(take, notTake);
    }

    //Tabulation
    public static int solve3(int[] nums){
        int n = nums.length;
        int dp[] = new int[n+1];

        if (n == 1) return nums[0];

        dp[0] = 0; //At 0 day we can't steal anything 
        dp[1] = nums[0];

        for (int i = 2; i <= n; i++) {
            int take = nums[i-1] + dp[i-2];
            int notTake = dp[i-1];

            dp[i] = Math.max(take, notTake);
        }

        return dp[n];
    }


    public static int solve4(int[] nums){
        int n = nums.length;
        if (n == 1) return nums[0];

        int prevPrev = 0; //At 0 day we can't steal anything 
        int prev = nums[0];

        for (int i = 2; i <= n; i++) {
            int take = nums[i-1] + prevPrev;
            int notTake = prev;

            int curr = Math.max(take, notTake);

            prevPrev = prev;
            prev = curr;
        }

        return prev;
    }



    public static void main(String[] args) {
        // int num1[] = {1,2,3,1};
        int num2[] = {2,7,9,3,1};

        // System.out.println(solve(num1, 0));
        // System.out.println(solve(num2, 0));

        int n = num2.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        System.out.println(solve2(num2, 0, dp));

        System.out.println(solve3(num2));

        System.out.println(solve4(num2));

    }
}