package DynamicProgramming;

public class MinimumPartitioning {
    //Tabulation
    public static int minPart(int arr[]){
        int n = arr.length;
        int sum = 0;

        for (int i : arr) sum += i;
        int W = sum/2;

        int dp[] = new int[W+1];

        for (int i = 0; i < n; i++) {
            int wt = arr[i];
            for (int j = W; j >= wt; j--) {
                dp[j] = Math.max(dp[j], arr[i] + dp[j-wt]);
            }
        }
        
        int sum1 = dp[W];
        int sum2 = sum - sum1;

        return Math.abs(sum1 - sum2);
    }

    public static void main(String[] args) {
        int arr[] = {1,6,8,5};
        System.out.println(minPart(arr));
    }

}