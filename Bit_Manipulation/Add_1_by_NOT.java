package Bit_Manipulation;

public class Add_1_by_NOT {
    public static void adding(int num){
        // using OR
        System.out.println(num | 1);

        // using NOT
        System.out.println(-(~num));
    }
    public static void main(String[] args) {
        adding(6);
    }
}