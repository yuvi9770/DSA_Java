package DynamicProgramming;

import java.util.Arrays;

public class LongestPalindromeSubString {
    //Appr - 1 (Recursion)
    public static boolean isPalin(String s, int i, int j){
        if (i >= j) return true;

        if (s.charAt(i) == s.charAt(j)) {
            return isPalin(s, i+1, j-1);
        }

        return false;
    }

    public static String solve(String s){
        int n = s.length();
        int maxLen = 1;
        int sp = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalin(s, i, j) && j-i+1 > maxLen) {
                    sp = i;
                    maxLen = j-i+1;
                }
            }
        }

        return s.substring(sp, sp + maxLen);
    }

    //Appr - 2 (Memoization) we can also use Boolean dp[][] which have three states - false, true, null
    public static boolean isPalin2(String s, int i, int j, int dp[][]){
        if (i >= j) return true;

        if (dp[i][j] != -1) return dp[i][j] == 1;

        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = isPalin2(s, i+1, j-1, dp) ? 1 : 0;

        }else{
            dp[i][j] = 0;
        }

        return dp[i][j] == 1;
    }

    public static String solve2(String s){
        int n = s.length();
        int maxLen = 1;
        int sp = 0;

        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalin2(s, i, j, dp) && j-i+1 > maxLen) {
                    sp = i;
                    maxLen = j-i+1;
                }
            }
        }

        return s.substring(sp, sp + maxLen);
    }

    //-----------MCM--------------
    public static String isPalin3(String s){
        int n = s.length();
        int maxLen = 1;
        int sp = 0;
        
        boolean dp[][] = new boolean[n][n];

        for (int i = 0; i < n; i++) dp[i][i] = true;

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n-len+1; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j) && (dp[i+1][j-1] || len == 2)) {
                    dp[i][j] = true;

                    if (len > maxLen) {
                        maxLen = len;
                        sp = i;
                    }
                }
            }
        }

        return s.substring(sp, sp + maxLen);
    }


    public static void main(String[] args) {
        String s = "babad";
        // System.out.println(solve(s));

        System.out.println(solve2(s));

        System.out.println(isPalin3(s));
    }
}