package DynamicProgramming;

import java.util.Arrays;

public class wildcardMatching {

    //Recursion
    public static boolean isMatch(String str1, String str2, int n, int m){
        if (m == 0) {
            return (n == 0);
        }

        if (n == 0) {
            for (int i = 0; i < m; i++) {
                if (str2.charAt(i) != '*') return false;
            }
            return true;
        }

        if (str1.charAt(n-1) == str2.charAt(m-1) || str2.charAt(m-1) == '?') {
            return isMatch(str1, str2, n-1, m-1);

        } else if (str2.charAt(m-1) == '*') {
            return isMatch(str1, str2, n, m-1) || isMatch(str1, str2, n-1, m);

        } else{
            return false;
        }
    }

    //Memoization -> here we have to use Boolean insted of boolean to compare the states
    public static boolean isMatch2(String str1, String str2, int n, int m, Boolean dp[][]){
        if (m == 0) {
            return (n == 0);
        }
        if (dp[n][m] != null) {
            return dp[n][m];
        }

        if (n == 0) {
            for (int i = 0; i < m; i++) {
                if (str2.charAt(i) != '*') 
                    return dp[n][m] = false;
            }
            return dp[n][m] = true;
        }

        if (str1.charAt(n-1) == str2.charAt(m-1) || str2.charAt(m-1) == '?') {
            return dp[n][m] =  isMatch2(str1, str2, n-1, m-1, dp);

        } else if (str2.charAt(m-1) == '*') {
            return dp[n][m] = isMatch2(str1, str2, n, m-1, dp) || isMatch2(str1, str2, n-1, m, dp);

        } else{
            return dp[n][m] = false;
        }
    }

    //Memoization -> here we have to use int[][] to compare the states
    public static boolean isMatch3(String str1, String str2, int n, int m, int dp[][]){
        if (m == 0) {
            return (n == 0);
        }
        if (dp[n][m] != -1) {
            return dp[n][m] == 1;
        }

        if (n == 0) {
            for (int i = 0; i < m; i++) {
                if (str2.charAt(i) != '*'){
                    dp[n][m] = 0;
                    return false;
                }  
            }
            dp[n][m] = 1;
            return true;
        }

        if (str1.charAt(n-1) == str2.charAt(m-1) || str2.charAt(m-1) == '?') {
            dp[n][m] = isMatch3(str1, str2, n-1, m-1, dp) ? 1:0;

        } else if (str2.charAt(m-1) == '*') {
            dp[n][m] = isMatch3(str1, str2, n, m-1, dp) || isMatch3(str1, str2, n-1, m, dp) ? 1:0;

        } else{
            dp[n][m] = 0;
        }
        return dp[n][m] == 1;
    }


    //Tabulation
    public static boolean isMatch4(String str1, String str2){
        int n = str1.length();
        int m = str2.length();

        boolean dp[][] = new boolean[n+1][m+1];
        dp[0][0] = true;

        for (int i = 1; i < n+1; i++) dp[i][0] = false;

        for (int j = 1; j < m+1; j++) {
            if (str2.charAt(j-1) == '*') 
                dp[0][j] = dp[0][j-1];
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1) || str2.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];

                }else if (str2.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];

                }else{
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "a*de";
        int n = str1.length();
        int m = str2.length();
        // System.out.println(isMatch(str1, str2, n, m));

        Boolean dp[][] = new Boolean[n+1][m+1];
        System.out.println(isMatch2(str1, str2, n, m, dp));

        int dp2[][] = new int[n+1][m+1];
        for (int i = 0; i < dp2.length; i++) {
            Arrays.fill(dp2[i], -1);
        }
        // System.out.println(isMatch3(str1, str2, n, m, dp2));


        System.out.println(isMatch4(str1, str2));
    }

    public static void print(boolean dp[][]){
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}