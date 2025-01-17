package Strings;

public class Palindrome {
    public static void isPalindrome(String name){
        int n = name.length();

        for (int i = 0; i < n/2; i++) {
            if (name.charAt(i) != name.charAt(n-1-i)) {
                System.out.println("Not a palindrome");
                return;   
            }
        }
        System.out.println("Yes, it is a palindrome");
    }
    
    public static void main(String[] args) {
        String name = "NooN";
        isPalindrome(name);
    }
}