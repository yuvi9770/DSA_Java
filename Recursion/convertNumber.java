package Recursion;

public class convertNumber {
    static String digit[] ={"zero","one","two","three","four","five","six","seven", "eight","nine"};
    
    public static void convert(int num){
        if (num == 0) {
            return;
        }
        int lastDigit = num % 10;
        convert(num/10);
        System.out.print(digit[lastDigit]+" ");

    }

    public static void main(String[] args) {
        convert(19650);
    }
}