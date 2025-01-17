package Bit_Manipulation;

public class Count_Set_Bit {
    public static int countBit(int num){
        int count = 0;

        int j = (int)Math.sqrt(num) + 1;
        for (int i = 0; i <= j; i++) {  //num > 0
            int LSB = num & 1;
            if (LSB == 1) {
                count++;
            }
            num >>= 1;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countBit(15));
        System.out.println(countBit(16));
    }
}