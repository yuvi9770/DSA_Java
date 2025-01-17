package Bit_Manipulation;

public class Update_ith_bit {
    public static int set(int num, int i){
        int bitmask = 1 << i;
        return (num | bitmask);
    }

    public static int clean(int num, int i){
        int bitmask = ~(1 << i);

        return (num & bitmask);
    }

    public static int update(int num,int i, int val){
        // if (val == 0) {
        //     return clean(num, i);
        // } else {
        //     return set(num, i);
        // }

        int n = clean(num, i);
        int bitmask = val << i;
        return (n | bitmask);
    }
    public static void main(String[] args) {
        System.out.println(update(10, 1, 0));
        System.out.println(update(10, 1, 1));
    }
}