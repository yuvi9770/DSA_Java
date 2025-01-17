package DynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubString {

    //Recursion
    public static int subStr(String str1, String str2, int n, int m, int count){
        if(n == 0 || m == 0) return count;

        int currCount = count;

        if (str1.charAt(n-1) == str2.charAt(m-1)) {
            currCount = subStr(str1, str2, n-1, m-1, count+1);
        }

        int diff1 = subStr(str1, str2, n-1, m, 0);
        int diff2 = subStr(str1, str2, n, m-1, 0);

        return Math.max(currCount, Math.max(diff1, diff2));
    }

    //the above recursion code is correct but required a 3-D array to apply memoization

    //Memoization
    public static int subStr2(String str1, String str2, int n, int m, int dp[][]){
        if(n == 0 || m == 0) return 0;

        if (dp[n][m] != -1) return dp[n][m];

        int currCount = 0;

        if (str1.charAt(n-1) == str2.charAt(m-1)) {
            currCount = 1+subStr2(str1, str2, n-1, m-1, dp);
        }

        int diff1 = subStr2(str1, str2, n-1, m, dp);
        int diff2 = subStr2(str1, str2, n, m-1, dp);

        return dp[n][m] = Math.max(currCount, Math.max(diff1, diff2));
    }

    //Tabulation
    public static int subStr3(String str1, String str2){
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n+1][m+1];
        int ans = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ans = Math.max(ans, dp[i][j]);

                }else{
                    dp[i][j] = 0;
                }
            }
        }
        // print(dp);

        return ans;
    }

    //Tabulation with space optimization of with 2 (1-D Array)
    public static int subStr4(String str1, String str2){
        int n = str1.length();
        int m = str2.length();

        if (n < m) return subStr4(str2, str1);

        int prev[] = new int[m+1];
        int curr[] = new int[m+1];
        int ans = 0;

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    curr[j] = prev[j-1] + 1;
                    ans = Math.max(ans, curr[j]);

                }
                // else{ // As prev and curr point to same array now this reset the result
                //     curr[j] = 0;
                // }
            }
            // print(prev);
            // print(curr);
            prev = curr;
            // int[] temp = prev;
            // prev = curr;
            // curr = temp;
        }

        return ans;
    }

    public static void print(int dp[]){
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "bcda";
        
        int n = str1.length();
        int m = str2.length();

        // System.out.println(subStr(str1, str2, n, m, 0));

        int dp[][] = new int[n+1][m+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        // System.out.println(subStr2(str1, str2, n, m, dp));

        // System.out.println(subStr3(str1, str2));

        System.out.println(subStr4(str1, str2));
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