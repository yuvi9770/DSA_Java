package Bit_Manipulation;

public class UpperCase_to_LowerCase {
    public static void convert(){

        for (char i = 'A'; i <= 'Z' ; i++) {
            System.out.print((char) (i | ' '));
        }
    }

    public static void main(String[] args) {
        convert();
    }
}