package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Longest_IncrSubSeq {

    //Recursion
    public static int incrSeq(int idx, int prev, int arr[]){
        if (idx == arr.length) return 0;

        int len = incrSeq(idx+1, prev, arr);

        if (prev == -1 || arr[idx] > arr[prev]) {
            len = Math.max(1 + incrSeq(idx+1, idx, arr), len);
        }

        return len;
    }

    //Memoization
    public static int incrSeq1(int idx, int prev, int arr[], int dp[][]){
        if (idx == arr.length) return 0;

        if (dp[idx][prev+1] != -1) return dp[idx][prev+1];

        int len = incrSeq1(idx+1, prev, arr, dp);

        if (prev == -1 || arr[idx] > arr[prev]) {
            len = Math.max(1 + incrSeq1(idx+1, idx, arr, dp), len);
        }

        return dp[idx][prev+1] = len;
    }

    // here we return dp[idx][next] rather then next+1 to adjust the size
    public static int incrSeq2(int idx, int next, int arr[], int dp[][]){
        if (idx < 0) return 0;

        if (dp[idx][next] != -1) return dp[idx][next];

        int len = incrSeq2(idx-1, next, arr, dp);

        if (next == arr.length || arr[idx] < arr[next]) {
            len = Math.max(1 + incrSeq2(idx-1, idx, arr, dp), len);
        }

        return dp[idx][next] = len;
    }

    //Tabulation ????------------
    public static int incrSeq3(int arr[]){
        int n = arr.length;
        int[][] dp = new int[n+1][n+1];

        for (int i = n-1; i >= 0; i--) {
            for (int j = i-1; j >= -1; j--) {

                if (j == -1 || arr[i] > arr[j]) {
                    dp[i][j + 1] = Math.max(dp[i + 1][j + 1], 1 + dp[i + 1][i + 1]);
                } 
                else {
                    dp[i][j + 1] = dp[i + 1][j + 1];
                }
            }
        }

        // print(dp);
        return dp[0][0];
    }

    //Tabulation Optimized
    public static int incrSeq4(int arr[]){
        int n = arr.length;
        int dp[] = new int[n];

        Arrays.fill(dp, 1);
        int maxi = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            maxi = Math.max(maxi, dp[i]);
            // print(dp);
        }

        return maxi;
    }

    //Tabluation method
    public static int inc(int arr[]){
        int n = arr.length;
        int[][] dp = new int[n][n];
        dp[0][0] = 1;
        int maxi = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    if (j == 0) {
                        dp[i][j] = 1 + dp[j][j];
                    }else{
                        dp[i][j] = Math.max(dp[i][j-1], 1 + dp[j][j-1]);
                    }
                    maxi = Math.max(maxi, dp[i][j]);

                }else{
                    if(j == 0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = dp[i][j-1];
                    }
                }
            }
        }
        return maxi;
    }


    // Using Binary Search
    public static int UsingBS(int arr[]){
        int n = arr.length;
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(arr[0]);
        int len = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] > temp.get(temp.size()-1)) {
                temp.add(arr[i]);
                len++;
                
            } else {
                int index = Collections.binarySearch(temp, arr[i]); 

                // if the element is not present then above function will return value [-(insertion point) - 1] where it can be insert
                if (index < 0) {
                    index = - (index+1);
                }

                temp.set(index, arr[i]);
            }
        }

        return len;
    }

    
    // create a array of sorted unique number and then find lcs of two array
    public static int lcs(int arr[], int arr2[]){
        int n = arr.length;
        int m = arr2.length;
        int dp[][] = new int[n+1][m+1];

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                
                if (arr[i-1] == arr2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
        
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }

    public static int lis(int arr[]){
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        // Integer[] arr2 = set.toArray(new Integer[set.size()]);
        int arr2[] = new int[set.size()];
        int i = 0;
        for (int num : set) {
            arr2[i++] = num;
        }
        
        Arrays.sort(arr2);
        return lcs(arr, arr2);
    }

    public static void main(String[] args) {
        int arr[] = {10,9,2,5,3,7,101,1};
        int arr2[] = {1,3,6,7,9,4,10,5,6};

        // System.out.println(lis(arr));
        // System.out.println(incrSeq(0, -1, arr));
        
        int n = arr.length;
        int dp[][] = new int[n][n+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        // System.out.println(incrSeq1(0, -1, arr, dp));
        // print(dp);

        // System.out.println(incrSeq2(n-1, n, arr, dp));
        // print(dp);

        // System.out.println(incrSeq3(arr));

        System.out.println(incrSeq4(arr2));

        // System.out.println(inc(arr2));

        System.out.println(UsingBS(arr2));

    }


    public static void print(int dp[]){
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
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