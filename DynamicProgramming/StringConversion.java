package DynamicProgramming;

public class StringConversion {

    //Tabulation
    public static int lcs(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return dp[n][m];
    }

    public static int minOper(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        int lcs = lcs(str1, str2);

        int del = n - lcs;
        int insert = m - lcs;

        return del + insert;
    }


    public static void main(String[] args) {
        String str1 = "abcdef";
        String str2 = "aceg";

        System.out.println(minOper(str1, str2));
    }
}