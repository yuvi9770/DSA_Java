package Recursion;

public class reverseString {
    public static void rev(String str, int len){
        if (len == str.length()) {
            return;
        }
        rev(str, len+1);
        System.out.print(str.charAt(len));
    }

    public static void main(String[] args) {
        String str = "abcd";
        rev(str, 0);
    }    
}