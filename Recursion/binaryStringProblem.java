package Recursion;

public class binaryStringProblem {
    public static void binaryString(int num, int lastPlace, String str){
        if (num == 0) {
            System.out.println(str);
            return;
        }

        binaryString(num - 1, 0, str+"0");

        if (lastPlace == 0) {
            binaryString(num - 1, 1, str+"1");
        }
    }

    public static void main(String[] args) {
        binaryString(3, 0, "");
    }
}