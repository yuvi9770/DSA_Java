package Bit_Manipulation;

public class OddEven {
    public static void odd_even(int num){
        int bitmask = 1;
        if ((num & bitmask) == 0) {
            System.out.println("Even number");
        } else {
            System.out.println("Odd number");
        }
    }
    public static void main(String[] args) {
        odd_even(5);
        odd_even(42);
        odd_even(0);
    }
}