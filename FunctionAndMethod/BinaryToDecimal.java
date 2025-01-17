package FunctionAndMethod;

public class BinaryToDecimal {
    
    public static void BinTODec(int n){
        int num = n;
        int Dec = 0;
        int LastDigit;

        for (int i = 0; n > 0 ; i++) {
            LastDigit = n % 10;
            Dec += (LastDigit * (int)Math.pow(2, i));
            n /= 10;
        }
        System.out.println("Decimal of " + num + " is " + Dec);
    }

    public static void main(String[] args) {
        BinTODec(10);    
    }
}
