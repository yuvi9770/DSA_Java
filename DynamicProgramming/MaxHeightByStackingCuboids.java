package DynamicProgramming;

import java.util.Arrays;

public class MaxHeightByStackingCuboids {

    public static int maxHeight(int[][] cuboids) {
        int n = cuboids.length;

        for(int[] cube : cuboids){
            Arrays.sort(cube);
        }

        Arrays.sort(cuboids, (a,b) -> {
            if(a[0] != b[0]) 
                return a[0] - b[0];
            else if(a[1] != b[1]) 
                return a[1] - b[1];
            else return a[2] - b[2];
        });

        int dp[] = new int[n];
        int ans  = 0; 

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {
                if (cuboids[j][0] <= cuboids[i][0] && cuboids[j][1] <= cuboids[i][1] && cuboids[j][2] <= cuboids[i][2]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }

            dp[i] += cuboids[i][2];
            ans = Math.max(ans, dp[i]);
        }
        
        return ans;
    }

    public static void main(String[] args) {
        // int arr [][] = {{50,45,20},{95,37,53},{45,23,12}};
        int arr [][] = {{38,25,45},{76,35,3}};
        System.out.println(maxHeight(arr));
    }
}