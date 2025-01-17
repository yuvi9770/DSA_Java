package Greedy;

import java.util.Arrays;

public class lexicographicSmallestStr {
    public static String getSmallest(int n, int k){
        char res[] = new char[n];
        Arrays.fill(res, 'a');
        k -= n;

        while (k > 0) {
            res[n-1] += Math.min(25, k);
            k -= Math.min(25, k);
            n--;
        }

        return String.valueOf(res);
    }
    public static void main(String[] args) {
        System.out.println(getSmallest(5, 57));

        System.out.println(getSmallest(3, 55));
    }
}