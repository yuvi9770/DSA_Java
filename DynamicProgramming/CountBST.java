package DynamicProgramming;

public class CountBST {
    
    //Tabulation
    public static int countTree(int n){
        int dp[] = new int[n+1];

        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            // Ci -> BST(i nodes) -> dp[i]
            for (int j = 0; j < i; j++) {
                int left = dp[j]; //left tree
                int right = dp[i-j-1]; //right tree

                dp[i] += left * right;
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(countTree(n));
    }
}