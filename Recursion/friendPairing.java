package Recursion;

public class friendPairing {
    public static int pairing(int num){
        if (num == 1 || num == 2) {
            return num;
        }
        // for single : pairing(num - 1)
        // for two : (num - 1) * pairing(num - 2)
        return pairing(num - 1) + ((num - 1) * pairing(num - 2));
    }
    public static void main(String[] args) {
        int num = 3;
        System.out.println(pairing(num));
    }
}