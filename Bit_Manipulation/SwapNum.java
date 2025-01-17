package Bit_Manipulation;

public class SwapNum {
    public static void Swap(int a, int b){
        System.out.println("Before Swap: a = " + a + " b = " + b);

        a = a^b;
        b = a^b;
        a = a^b;

        System.out.println("After Swap: a = " + a + " b = " + b);
    }
    public static void main(String[] args) {
        Swap(5, 6);
    }
}