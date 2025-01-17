package Bit_Manipulation;

public class Get_ith_Bit {
    public static int get(int num, int i){
        int bitmask = 1 << i;
        if ((num & bitmask) == 0) {
            return 0;
        } else {
            return 1;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(get(15, 2));
        System.out.println(get(15, 4));
    }
}