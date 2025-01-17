package DynamicProgramming;

public class TargetSumSubset {

    public static boolean isTarget(int arr[], int sum){
        int n = arr.length;
        boolean dp[][] = new boolean[n+1][sum+1];

        // i = items && j = target
        for (int i = 0; i < n+1; i++) dp[i][0] = true;

        for (int i = 1; i < n+1; i++) {
            int v = arr[i-1];

            for (int j = 1; j < sum+1; j++) {

                if (v <= j && dp[i-1][j-v] == true) { //include
                    dp[i][j] = true;

                }else if (dp[i-1][j] == true) { //exclude
                    dp[i][j] = true;
                }
            }
        }

        return dp[n][sum];
    }

    // using less space
    public static boolean isTarget2(int arr[], int sum){
        int n = arr.length;
        boolean dp[] = new boolean[sum+1];

        dp[0] = true;

        for (int i = 0; i < n; i++) {
            int v = arr[i];

            for (int j = sum; j >= v; j--) {
                if (dp[j-v] == true) { //include
                    dp[j] = true;
                }
            }
        }

        return dp[sum];
    }

    public static void main(String[] args) {
        int arr[] = {4,2,7,1,3};
        int sum = 10;
        // System.out.println(isTarget(arr, sum));

        System.out.println(isTarget2(arr, sum));
    }
}