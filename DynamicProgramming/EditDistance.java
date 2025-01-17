package DynamicProgramming;

import java.util.Arrays;

public class EditDistance {
    //Recursion
    public static int dis(String str1, String str2, int i, int j){ // from start to end

        if (i == str1.length()) return str2.length() - j; // insert in s1

        if (j == str2.length()) return str1.length() - i; // delete from s1

        if (str1.charAt(i) == str2.charAt(j)) {
            return dis(str1, str2, i+1, j+1);
            
        } else {
            int insert = 1 + dis(str1, str2, i, j+1);
            int delele = 1 + dis(str1, str2, i+1, j);
            int replace = 1 + dis(str1, str2, i+1, j+1);

            return Math.min(replace, Math.min(insert, delele));
        }
    }

    public static int dis2(String str1, String str2, int m, int n){ // from end tko start

        if (m == 0 || n == 0) return m + n;

        if (str1.charAt(m-1) == str2.charAt(n-1)) {
            return dis2(str1, str2, m-1, n-1);
            
        } else {
            int insert = 1 + dis2(str1, str2, m, n-1);
            int delele = 1 + dis2(str1, str2, m-1, n);
            int replace = 1 + dis2(str1, str2, m-1, n-1);

            return Math.min(replace, Math.min(insert, delele));
        }
    }

    //Memoization
    public static int dis3(String str1, String str2, int m, int n, int dp[][]){

        if (m == 0 || n == 0) return m + n;

        if (dp[m][n] != -1) return dp[m][n];

        if (str1.charAt(m-1) == str2.charAt(n-1)) {
            return dp[m][n] = dis3(str1, str2, m-1, n-1, dp);
            
        } else {
            int insert = 1 + dis3(str1, str2, m, n-1, dp);
            int delele = 1 + dis3(str1, str2, m-1, n, dp);
            int replace = 1 + dis3(str1, str2, m-1, n-1, dp);

            return dp[m][n] = Math.min(replace, Math.min(insert, delele));
        }
    }

    //Tabulation
    public static int dis4(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];
        
        // initialize (base case)
        for (int i = 0; i < n; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j < m; j++) {
            dp[0][j] = j;
        }

        //
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];

                }else{
                    int add = dp[i][j-1];
                    int del = dp[i-1][j];
                    int rep = dp[i-1][j-1];
                    dp[i][j] = 1 + Math.min(add, Math.min(del, rep));
                }
            }
        }
        
        return dp[n][m];
    }


    //Tabulation (code story with MIK)
    public static int dis5(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];
    
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = i+j;
                }
                else if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];

                }else{
                    dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
                }
            }
        }
        
        return dp[n][m];
    }

    public static void main(String[] args) {
        String str1 = "intention";
        String str2 = "execution";
        int m = str1.length();
        int n = str2.length();

        // System.out.println(dis(str1, str2, 0, 0));

        // System.out.println(dis2(str1, str2, m, n));

        int dp[][] = new int[m+1][n+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        // System.out.println(dis3(str1, str2, m, n, dp));

        System.out.println(dis4(str1, str2));

        System.out.println(dis5(str1, str2));
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