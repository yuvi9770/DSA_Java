package FunctionAndMethod;

public class DecimalToBinary {

    public static void DecToBin(int n){
        int num = n;
        int rem;
        int Bin = 0;

        for (int i = 0; n > 0; i++) {
            rem = n%2;
            Bin += (rem * (int)Math.pow(10,i));
            n /= 2;
        }
        System.out.println("Binary of " + num + " is " + Bin);

    }

    public static void main(String[] args) {
        DecToBin(8);
    }
}
