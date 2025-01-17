package Recursion;

public class getMazePath {
    public static int countPath(int i, int j, int n, int m){
        if (i == n || j == m) {
            return 0;
        }
        if (i == n-1 && j == m-1) {
            return 1;
        }
        // move downwards : countPath(i+1, j, n, m)
        // move right : countPath(i , j+1, n, m)

        return countPath(i+1, j, n, m) + countPath(i, j+1, n, m);
    }

    public static void main(String[] args) {
        int n = 3, m = 3;
        System.out.println(countPath(0, 0, n, m));
    }
}