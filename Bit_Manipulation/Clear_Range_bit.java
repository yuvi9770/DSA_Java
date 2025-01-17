package Bit_Manipulation;

public class Clear_Range_bit {

    public static int clean(int num, int i, int j){
        int right_one = ((-1) << (j+1));
        int left_one = (1 << i) - 1;
        int bitmask = right_one | left_one;
        return (num & bitmask);
    }

    public static void main(String[] args) {
        System.out.println(clean(10, 2,4));
    }
}