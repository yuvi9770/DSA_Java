package DynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubSequence {

    //Recursion
    public static int lcs(String str1, String str2, int n, int m){
        if (n == 0 || m == 0) return 0;

        if (str1.charAt(n-1) == str2.charAt(m-1)) {
            return 1 + lcs(str1, str2, n-1, m-1);

        }else{
            return Math.max(lcs(str1, str2, n-1, m), lcs(str1, str2, n, m-1));
        }
    }

    //Memoization
    public static int lcs2(String str1, String str2, int n, int m, int dp[][]){
        if (n == 0 || m == 0) return 0;

        if (dp[n][m] != -1) return dp[n][m];

        if (str1.charAt(n-1) == str2.charAt(m-1)) {
            return dp[n][m] = 1 + lcs2(str1, str2, n-1, m-1, dp);

        }else{
            return dp[n][m] = Math.max(lcs2(str1, str2, n-1, m, dp), lcs2(str1, str2, n, m-1, dp));
        }
    }

    //Tabulation
    public static int lcs3(String str1, String str2){
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n+1][m+1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;

                }else{
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }

        return dp[n][m];
    }
    
    
    //Tabulation with space optimization of with 2 (1-D Array)
    public static int lcs4(String str1, String str2){
        int n = str1.length();
        int m = str2.length();

        if (n < m) lcs4(str2, str1); // help to choose the min(appr.) space

        int prev[] = new int[m+1];
        int curr[] = new int[m+1];

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    curr[j] = prev[j-1] + 1;

                }else{
                    int ans1 = curr[j-1];
                    int ans2 = prev[j];
                    curr[j] = Math.max(ans1, ans2);
                }
            }
            prev = curr;
        }

        return prev[m];
    }


    //Tabulation with space optimization of with 1 (1-D Array)
    public static int lcs5(String str1, String str2){
        int n = str1.length();
        int m = str2.length();

        if (n < m) lcs4(str2, str1); // help to choose the appr. space

        int dp[] = new int[m+1];

        for (int i = 1; i < n+1; i++) {
            int prevDiag = 0;

            for (int j = 1; j < m+1; j++) {
                int temp = dp[j]; //save the (i-1,j-1) for next time

                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[j] = prevDiag + 1;

                }else{
                    int ans1 = dp[j];
                    int ans2 = dp[j-1];
                    dp[j] = Math.max(ans1, ans2);
                }

                prevDiag = temp;
            }
        }

        return dp[m];
    }

    public static void main(String[] args) {
        String str1 = "abcdge";
        String str2 = "abedg";
        int n = str1.length();
        int m = str2.length();

        // System.out.println(lcs(str1, str2, n, m));

        int dp[][] = new int[n+1][m+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        // System.out.println(lcs2(str1, str2, n, m, dp));
        // print(dp);

        // System.out.println(lcs3(str1, str2));

        System.out.println(lcs4(str1, str2));

        // System.out.println(lcs5(str1, str2));
    }

    public static void print(int dp[][]){
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}