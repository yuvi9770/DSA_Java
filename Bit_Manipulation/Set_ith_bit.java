package Bit_Manipulation;

public class Set_ith_bit {
    public static int set(int num, int i){
        int bitmask = 1 << i;
        return (num | bitmask);
    }
    public static void main(String[] args) {
        System.out.println(set(10, 2));
        System.out.println(set(10, 3));
    }
}