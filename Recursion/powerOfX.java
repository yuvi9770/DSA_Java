package Recursion;

public class powerOfX {
    public static int power(int num, int pow){
        if (pow == 0) {
            return 1;
        }

        return num * power(num, --pow);
    }
    public static void main(String[] args) {
        int num = 2;
        int pow = 10;
        System.out.println(power(num, pow));
    }
}