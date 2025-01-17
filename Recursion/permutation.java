package Recursion;

public class permutation {
    public static void per(String str, String newStr){
        if (str.length() == 0) {
            System.out.println(newStr);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i) + str.substring(i+1);
            per(left, newStr + str.charAt(i));
        }
    }
    public static void main(String[] args) {
        per("abc", "");
    }
}