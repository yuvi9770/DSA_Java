package Bit_Manipulation;

public class isPower_two {
    public static boolean isPower(int num){
        return ((num & (num-1)) == 0);


        // double logN = Math.log(num) / Math.log(2);
        // return logN == (int) logN;

        
        // while (num != 1) {
        //     if (num % 2 != 0) {
        //         return false;
        //     }
        //     num /= 2;
        // }
        // return true;
    }
    public static void main(String[] args) {
        System.out.println(isPower(8));
        System.out.println(isPower(6));
    }
}