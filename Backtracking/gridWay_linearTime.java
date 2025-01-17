package Backtracking;

public class gridWay_linearTime {
    public static int fact(int num){
        if (num == 0) {
            return 1;
        }else if (num < 0) {
            return num;
        }

        return num * fact(num-1);
    }

    // using permutation to find the ways in linear time
    public static void counts(int n, int m){
        int ways = fact(n+m-2) / (fact(n-1) * fact(m-1));
        System.out.println(ways);
    }

    public static void main(String[] args) {
        int n = 3, m = 3;
        counts(n, m);
    }
}