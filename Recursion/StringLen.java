package Recursion;

public class StringLen {
    public static int len(String str){
        if (str.length() == 0) {
            return 0;
        }

        return 1 + len(str.substring(1));
    }
    
    public static void main(String[] args) {
        System.out.println(len("Hello"));
    }
}