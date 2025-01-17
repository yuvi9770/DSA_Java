package Bit_Manipulation;

public class Clear_last_ith_Bit {
    public static int clean(int num,int i){
        int bitmask = (-1) << i;

        return (num & bitmask);
    }
    public static void main(String[] args) {
        System.out.println(clean(15, 2));
    }
}