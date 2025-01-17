package DynamicProgramming;

public class MountainRanges {
    //Tabulation
    public static int possibleWay(int n){
        int dp[] = new int[n+1];

        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // n pairs -> mountain Range -> Ci

                int inside = dp[j]; //inside possible arrangement
                int outside = dp[i-j-1]; //outside possible arrangement
                dp[i] += inside * outside;
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(possibleWay(n));
    }
}