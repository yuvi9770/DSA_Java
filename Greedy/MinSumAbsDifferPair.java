package Greedy;

import java.util.Arrays;

public class MinSumAbsDifferPair {
    public static void AbsMinDiff(int A[], int B[]){
        Arrays.sort(A);
        Arrays.sort(B);

        int minDiff = 0;
        for (int i = 0; i < A.length; i++) {
            minDiff += Math.abs(A[i] - B[i]);
        }
        System.out.println(minDiff);
    }
    public static void main(String[] args) {
        int A[] = {1,2,3};
        int B[] = {2,1,3};
        AbsMinDiff(A, B);

        AbsMinDiff(new int[] {4,1,8,7}, new int[] {2,3,6,5});
    }
}