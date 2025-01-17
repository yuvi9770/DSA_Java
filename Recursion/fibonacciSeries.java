package Recursion;

public class fibonacciSeries {
    public static void fun(int n, int a, int b){
        if (n == 0) {
            return;
        }
        int c = a+b;
        System.out.println(c);
        fun(n-1, b, c);
    }
    
    public static void main(String[] args) {
        int a = 0, b = 1;
        int n = 7;
        System.out.println(a);
        System.out.println(b);
        fun(n-2, a, b);
    }
}