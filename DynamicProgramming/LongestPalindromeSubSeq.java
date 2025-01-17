package DynamicProgramming;

import java.util.Arrays;

public class LongestPalindromeSubSeq {
    //Appr - 1 -> here we reverse the string and find the LCS
    public static int lps1(String s1, String s2, int n, int m, int dp[][]){
        if (n == 0 || m == 0) return 0;

        if (dp[n][m] != -1) return dp[n][m];

        if (s1.charAt(n-1) == s2.charAt(m-1)) {
            return dp[n][m] = 1 + lps1(s1, s2, n-1, m-1, dp);

        }else{
            return dp[n][m] = Math.max(lps1(s1, s2, n-1, m, dp), lps1(s1, s2, n, m-1, dp));
        }
    }

    public static int solve(String s){
        String s1 = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int dp[][] = new int[n+1][n+1];

        for (int i = 0; i < n+1; i++) {
            Arrays.fill(dp[i], -1);
        }

        return lps1(s, s1, n, n, dp);
    }

    //Appr - 2 - Two pointer AND MCM
    public static int lps2(String str, int i, int j, int dp[][]){
        if (i > j) return 0;

        if (i == j) return 1;

        if (dp[i][j] != -1) return dp[i][j];

        if (str.charAt(i) == str.charAt(j)) {
            return dp[i][j] = 2 + lps2(str, i+1, j-1, dp);

        }else{
            return dp[i][j] = Math.max(lps2(str, i+1, j, dp), lps2(str, i, j-1, dp));
        }
    }

    public static int solve2(String s){
        int n = s.length();
        int dp[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return lps2(s, 0, n-1, dp);
    }

    //-----------MCM--------------
    public static int lps3(String str){
        int n = str.length();

        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = 1;

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n-len+1; i++) {
                int j = i+len-1;

                if(str.charAt(i) == str.charAt(j)){
                    dp[i][j] = 2 + dp[i+1][j-1];

                }else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }

        return dp[0][n-1];
    }



    public static void main(String[] args) {
        String str = "bbbab";
        // System.out.println(solve(str));

        System.out.println(solve2(str));

        System.out.println(lps3(str));
    }
}