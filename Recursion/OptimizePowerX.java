package Recursion;

public class OptimizePowerX {
    
    public static int power(int num, int pow){
        if (pow == 0) {
            return 1;
        }

        int halfPower = power(num, pow/2);

        if (pow % 2 == 0) {
            return halfPower * halfPower;
        } else {
            return num * halfPower * halfPower;
        }
    }
    public static void main(String[] args) {
        int num = 2;
        int pow = 10;
        
        System.out.println(power(num, pow));
    }
}