package Recursion;

public class IncrPrintNumber {
    public static void printIncr(int n){
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        
        printIncr(n - 1);
        System.out.print(n + " ");
    }
    public static void main(String[] args) {
        int n = 6;
        printIncr(n);
    }
}