package DynamicProgramming;

public class PartitionEqualSubsetSum {

    public static boolean isEqualSub(int arr[]){
        int n = arr.length;

        int sum = 0;
        for(int i : arr) sum += i;

        // if sum is odd then return false
        if(sum % 2 != 0) return false;

        int W = sum/2;
        int dp[] = new int[W+1];

        for (int i = 0; i < n; i++) {
            int wt = arr[i];
            for (int j = W; j >= wt; j--) {
                
                dp[j] = Math.max(dp[j], arr[i] + dp[j-wt]);
            }
        }

        // int sum1 = dp[W];
        // int sum2 = sum - sum1;
        // return sum1 == sum2;
        return dp[W] == W;
    }

    public static void main(String[] args) {
        int nums[] = {1,5,11,5};
        System.out.println(isEqualSub(nums));
    }
}